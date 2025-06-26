package com.ckai.vehicle.controller;


import com.ckai.common.result.Result;
import com.ckai.vehicle.domain.Warnings;
import com.ckai.vehicle.dto.warning.WarningDTO;
import com.ckai.vehicle.dto.warning.WarningJson;
import com.ckai.vehicle.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/warning")
public class WarningController {

    @Autowired
    private WarningService warningService;

    //根据用户上传的Json数据判断是否预警
    @PostMapping("check")
    public Result<List<WarningDTO>> processWarnData(@RequestBody List<WarningJson> warningJsonList) {
        System.out.println(warningJsonList);
        try{
            List<WarningDTO> results = warningService.processWarnData(warningJsonList);
            System.out.println( results);
            return Result.success(results);
        }catch (Exception e){
            return Result.error("失败" + e.getMessage());
        }


    }

}
