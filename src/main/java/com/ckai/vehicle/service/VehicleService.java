package com.ckai.vehicle.service;

import com.ckai.common.result.PageResult;
import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.dto.VehicleDTO;
import com.ckai.vehicle.dto.VehiclePageQueryDTO;

public interface VehicleService {
    void save(VehicleDTO vehicleDTO);

    void update(VehicleDTO vehicleDTO);

    VehicleInfo getById(Long id);

    PageResult pageQuery(VehiclePageQueryDTO vehiclePageQueryDTO);
}
