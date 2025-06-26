package com.ckai.vehicle.service.impl;

import com.ckai.common.result.PageResult;
import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.dto.VehicleDTO;
import com.ckai.vehicle.dto.VehiclePageQueryDTO;
import com.ckai.vehicle.mapper.VehicleInfoMapper;
import com.ckai.vehicle.service.VehicleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleInfoMapper vehicleInfoMapper;

    @Override
    public void save(VehicleDTO vehicleDTO) {
        VehicleInfo vehicleInfo = new VehicleInfo();
        BeanUtils.copyProperties(vehicleDTO, vehicleInfo);
        vehicleInfo.setCreateTime(LocalDateTime.now());
        vehicleInfo.setUpdateTime(LocalDateTime.now());
        vehicleInfoMapper.insert(vehicleInfo);
    }

    @Override
    public void update(VehicleDTO vehicleDTO) {
        VehicleInfo vehicleInfo = new VehicleInfo();
        BeanUtils.copyProperties(vehicleDTO, vehicleInfo);
        vehicleInfo.setUpdateTime(LocalDateTime.now());
        vehicleInfoMapper.update(vehicleInfo);
    }



    public PageResult pageQuery(VehiclePageQueryDTO vehiclePageQueryDTO ) {
        PageHelper.startPage(vehiclePageQueryDTO.getPage(), vehiclePageQueryDTO.getPageSize());
        Page<VehicleInfo> page = vehicleInfoMapper.pageQuery(vehiclePageQueryDTO);
        long total = page.getTotal();
        List<VehicleInfo> result = page.getResult();
        System.out.println(result);
        return new PageResult(total, result);
    }

    @Override
    public VehicleInfo getById(Long id) {
        VehicleInfo vehicleInfo = vehicleInfoMapper.getById(id);
        System.out.println(vehicleInfo);
        // VehicleDTO vehicleDTO = new VehicleDTO();
        // BeanUtils.copyProperties(vehicleInfo, vehicleDTO);
        return vehicleInfo;
    }
}
