package com.ckai.vehicle.service;

import com.ckai.vehicle.dto.warning.WarningDTO;
import com.ckai.vehicle.dto.warning.WarningJson;

import java.util.List;

public interface WarningService {
    List<WarningDTO> processWarnData(List<WarningJson> warningJson);
}
