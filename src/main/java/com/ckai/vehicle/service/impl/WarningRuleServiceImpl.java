package com.ckai.vehicle.service.impl;

import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.domain.WarningRules;
import com.ckai.vehicle.dto.WarningRuleDTO;
import com.ckai.vehicle.mapper.VehicleInfoMapper;
import com.ckai.vehicle.mapper.WarningRuleMapper;
import com.ckai.vehicle.service.WarningRuleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WarningRuleServiceImpl implements WarningRuleService {

    @Autowired
    private WarningRuleMapper warningRuleMapperr;

    @Override
    public void save(WarningRuleDTO warningRuleDTO) {
        // 假设我们将WarningRuleDTO转换为VehicleInfo并保存
        WarningRules warningRules = new WarningRules();
        BeanUtils.copyProperties(warningRuleDTO, warningRules);
        warningRules.setCreateTime(LocalDateTime.now());
        warningRules.setUpdateTime(LocalDateTime.now());
        warningRuleMapperr.insert(warningRules);
    }


    @Override
    public void update(WarningRuleDTO warningRuleDTO) {
        // 假设我们从WarningRuleDTO更新VehicleInfo
        WarningRules warningRules = new WarningRules();
        BeanUtils.copyProperties(warningRuleDTO, warningRules);
        warningRules.setUpdateTime(LocalDateTime.now());
        warningRuleMapperr.update(warningRules);
    }

    @Override
    public WarningRules getById(Long id) {
        return warningRuleMapperr.getById(id);
    }

    @Override
    public List<WarningRules> getByBatteryType(Integer batteryType) {
        return warningRuleMapperr.getByBatteryType(batteryType);
    }
}
