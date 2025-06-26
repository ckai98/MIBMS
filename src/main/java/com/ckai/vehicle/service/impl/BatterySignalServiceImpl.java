package com.ckai.vehicle.service.impl;

import com.ckai.vehicle.domain.BatterySignals;
import com.ckai.vehicle.dto.BatterySignalDTO;
import com.ckai.vehicle.mapper.BatterySignalMapper;
import com.ckai.vehicle.service.BatterySignalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class BatterySignalServiceImpl implements BatterySignalService {

    @Autowired
    private BatterySignalMapper batterySignalMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void save(BatterySignalDTO batterySignalDTO) {
        System.out.println(batterySignalDTO.getIx());
        BatterySignals batterySignals = new BatterySignals();
        BeanUtils.copyProperties(batterySignalDTO, batterySignals);
        batterySignals.setCreateTime(LocalDateTime.now());
        batterySignalMapper.insert(batterySignals);

        // 将数据同步到Redis缓存，并设置合理的过期时间以保证一致性
        String cacheKey = "batterySignal:" + batterySignals.getId();
        redisTemplate.opsForValue().set(cacheKey, batterySignals);

        // 设置缓存过期时间为30分钟，防止脏数据长期存在
        redisTemplate.expire(cacheKey, 30, TimeUnit.MINUTES);
    }

    @Override
    public BatterySignals getById(Long id) {
        String cacheKey = "batterySignal:" + id;

        // 从Redis中获取缓存数据
        BatterySignals batterySignals = (BatterySignals) redisTemplate.opsForValue().get(cacheKey);

        if (batterySignals == null) {
            // 如果缓存未命中，从数据库查询
            batterySignals = batterySignalMapper.getById(id);

            if (batterySignals != null) {
                // 将数据写入缓存，并设置过期时间（例如：30分钟）
                redisTemplate.opsForValue().set(cacheKey, batterySignals);
                redisTemplate.expire(cacheKey, 30, TimeUnit.MINUTES);
            }
        }

        return batterySignals;
    }

    @Override
    public List<BatterySignals> getRecentSignalReports(Integer time) {
        LocalDateTime since = LocalDateTime.now().minusMinutes(time);
        List<BatterySignals> batterySignalS = batterySignalMapper.getRecentSignalReports(since);
        return batterySignalS;
    }
}
