package com.ckai.vehicle.service.impl;

import com.ckai.vehicle.domain.BatterySignals;
import com.ckai.vehicle.dto.BatterySignalDTO;
import com.ckai.vehicle.mapper.BatterySignalMapper;
import com.ckai.vehicle.service.BatterySignalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BatterySignalServiceImpl implements BatterySignalService {

    @Autowired
    private BatterySignalMapper batterySignalMapper;
    @Override
    public void save(BatterySignalDTO batterySignalDTO) {
        System.out.println(batterySignalDTO.getIx());
        BatterySignals batterySignals = new BatterySignals();
        BeanUtils.copyProperties(batterySignalDTO, batterySignals);
        batterySignals.setCreateTime(LocalDateTime.now());
        batterySignalMapper.insert(batterySignals);
    }

    @Override
    public List<BatterySignals> getRecentSignalReports(Integer time) {
        LocalDateTime since = LocalDateTime.now().minusMinutes(time);
        List<BatterySignals> batterySignalS = batterySignalMapper.getRecentSignalReports(since);
        return batterySignalS;
    }
}
