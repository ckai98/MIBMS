package com.ckai.vehicle.service;

import com.ckai.vehicle.domain.WarningRules;
import com.ckai.vehicle.dto.WarningRuleDTO;
import com.ckai.vehicle.domain.VehicleInfo;

import java.util.List;

public interface WarningRuleService {
    void save(WarningRuleDTO warningRuleDTO);
    // void deleteById(Long id);
    void update(WarningRuleDTO warningRuleDTO);
    WarningRules getById(Long id);
    List<WarningRules> getByBatteryType(Integer batteryType);
}
