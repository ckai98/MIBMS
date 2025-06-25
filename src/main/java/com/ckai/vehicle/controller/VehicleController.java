package com.ckai.vehicle.controller;

import com.ckai.common.result.PageResult;
import com.ckai.common.result.Result;
import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.dto.VehicleDTO;
import com.ckai.vehicle.dto.VehiclePageQueryDTO;
import com.ckai.vehicle.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    //新增车辆信息
    @PostMapping
    @ApiOperation("新增车辆信息")
    public Result save(@RequestBody VehicleDTO vehicleDTO) {
        log.info("新增车辆信息：{}", vehicleDTO);
        vehicleService.save(vehicleDTO);
        return Result.success();
    }
    //修改车辆信息
    @PutMapping
    public Result update(@RequestBody VehicleDTO vehicleDTO) {
        log.info("修改车辆信息：{}", vehicleDTO);
        vehicleService.update(vehicleDTO);
        return Result.success();
    }

    //删除车辆信息


    //根据id查询车辆信息
    @GetMapping("/{id}")
    public Result<VehicleInfo> getById(@PathVariable Long id) {
        log.info("查询车辆信息：{}", id);
        VehicleInfo vehicleInfo = vehicleService.getById(id);
        return Result.success(vehicleInfo);
    }
    //分页查询车辆信息列表
    @GetMapping("/page")
    public Result<PageResult> list(VehiclePageQueryDTO vehiclePageQueryDTO) {
        log.info("分页查询车辆信息列表：{}", vehiclePageQueryDTO);
        PageResult pageResult = vehicleService.pageQuery(vehiclePageQueryDTO);
        return Result.success(pageResult);
    }



}
