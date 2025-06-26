package com.ckai.vehicle.service;

import com.ckai.vehicle.domain.BatterySignals;
import com.ckai.vehicle.dto.BatterySignalDTO;

import java.util.List;

public interface BatterySignalService {
    void save(BatterySignalDTO batterySignalDTO);

    List<BatterySignals> getRecentSignalReports(Integer time);

    BatterySignals getById(Long id);
}
