package com.ckai.vehicle.controller;


import com.ckai.common.result.Result;
import com.ckai.vehicle.domain.BatterySignals;
import com.ckai.vehicle.dto.BatterySignalDTO;
import com.ckai.vehicle.service.BatterySignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signal")
public class BatterySignalController {

    @Autowired
    private BatterySignalService batterySignalService;

    @PostMapping
    public Result save(@RequestBody BatterySignalDTO batterySignalDTO) {
        batterySignalService.save(batterySignalDTO);
        return Result.success();
    }

    @GetMapping("/id/{id}")
    public BatterySignals getById(@PathVariable Long id){
        return batterySignalService.getById(id);
    }

    //获取最近五分钟的所有信号记录
    @GetMapping("/{time}")
    public Result<List<BatterySignals>> getRecentSignalReports(@PathVariable Integer time) {
        return Result.success(batterySignalService.getRecentSignalReports(time));
    }
}
