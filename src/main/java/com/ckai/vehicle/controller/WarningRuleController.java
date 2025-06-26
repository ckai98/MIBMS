package com.ckai.vehicle.controller;

import com.ckai.common.result.Result;
import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.domain.WarningRules;
import com.ckai.vehicle.dto.VehicleDTO;
import com.ckai.vehicle.dto.WarningRuleDTO;
import com.ckai.vehicle.service.WarningRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rule")
public class WarningRuleController {

    @Autowired
    private WarningRuleService warningRuleService;

    //增
    @PostMapping
    public Result save(@RequestBody WarningRuleDTO warningRuleDTO){
        warningRuleService.save(warningRuleDTO);
        return Result.success();
    }

    //删
    // public Result deleteById(@PathVariable Long id) {
    //     warningRuleService.deleteById(id);
    //     return Result.success();
    // }

    //改
    @PutMapping
    public Result update(@RequestBody WarningRuleDTO warningRuleDTO) {
        warningRuleService.update(warningRuleDTO);
        return Result.success();
    }

    //查
    @GetMapping("/{id}")
    public Result<WarningRules> getById(@PathVariable Long id) {
        WarningRules warningRules = warningRuleService.getById(id);
        return Result.success(warningRules);
    }

    @GetMapping("/batteryType/{batteryType}")
    public Result<List<WarningRules>> getByBatteryType(@PathVariable Integer batteryType) {
        List<WarningRules> warningRules = warningRuleService.getByBatteryType(batteryType);
        return Result.success(warningRules);
    }
}
