package com.ckai.vehicle.service.impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

// 添加缺失的import
import com.ckai.vehicle.dto.VehicleDTO;
import com.ckai.vehicle.dto.VehiclePageQueryDTO;
import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.mapper.VehicleInfoMapper;
import com.ckai.vehicle.service.VehicleService;
import com.ckai.common.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class VehicleServiceImplTest {

    @Mock
    private VehicleInfoMapper vehicleInfoMapper;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        // 准备测试数据
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVid("VIN1234567890ABC");
        vehicleDTO.setBatteryType(1);
        vehicleDTO.setTotalMileage(new BigDecimal("50000"));
        vehicleDTO.setBatteryHealth(new BigDecimal("85"));

        // 调用服务方法
        vehicleService.save(vehicleDTO);

        verify(vehicleInfoMapper).insert(any(VehicleInfo.class));
    }

    @Test
    public void testGetById() {
        // Arrange
        Long id = 1L;
        VehicleInfo expectedVehicleInfo = new VehicleInfo();
        expectedVehicleInfo.setId(id);
        expectedVehicleInfo.setVid("VIN1234567890ABC");
        expectedVehicleInfo.setBatteryType(1);
        expectedVehicleInfo.setTotalMileage(new BigDecimal("50000"));
        expectedVehicleInfo.setBatteryHealth(new BigDecimal("85"));

        when(vehicleInfoMapper.getById(id)).thenReturn(expectedVehicleInfo);

        // Act
        VehicleInfo actualVehicleInfo = vehicleService.getById(id);

        // Assert
        assertNotNull(actualVehicleInfo);
        assertEquals(expectedVehicleInfo.getId(), actualVehicleInfo.getId());
        assertEquals(expectedVehicleInfo.getVid(), actualVehicleInfo.getVid());
        assertEquals(expectedVehicleInfo.getBatteryType(), actualVehicleInfo.getBatteryType());
        assertEquals(expectedVehicleInfo.getTotalMileage(), actualVehicleInfo.getTotalMileage());
        assertEquals(expectedVehicleInfo.getBatteryHealth(), actualVehicleInfo.getBatteryHealth());
        verify(vehicleInfoMapper, times(1)).getById(id); // 使用times(1)明确验证调用次数
    }

    @Test
    public void testUpdate() {
        // 准备测试数据
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setVid("VIN1234567890");

        // 执行测试
        vehicleService.update(vehicleDTO);

        // 验证vehicleInfoMapper.update被调用一次
        verify(vehicleInfoMapper, times(1)).update(any(VehicleInfo.class));
    }

    @Test
    public void testPageQuery() {
        // 准备测试数据
        VehiclePageQueryDTO pageQueryDTO = new VehiclePageQueryDTO();
        pageQueryDTO.setPage(1);
        pageQueryDTO.setPageSize(10);

        // 创建模拟的分页结果
        VehicleInfo vehicleInfo = new VehicleInfo();
        vehicleInfo.setId(1L);
        vehicleInfo.setVid("VIN1234567890");

        List<VehicleInfo> resultList = Arrays.asList(vehicleInfo);

        // 使用构造函数创建Page对象
        Page<VehicleInfo> mockPage = new Page<>(1, 10, true);
        mockPage.addAll(resultList);
        mockPage.setTotal(1);

        // 设置mock对象的行为
        when(vehicleInfoMapper.pageQuery(pageQueryDTO)).thenReturn(mockPage);

        // 执行测试
        PageResult result = vehicleService.pageQuery(pageQueryDTO);

        // 验证结果
        assertNotNull(result);
        assertEquals(1, result.getTotal());
        assertEquals(resultList, result.getRecords());

        // 验证vehicleInfoMapper.pageQuery被调用一次
        verify(vehicleInfoMapper, times(1)).pageQuery(pageQueryDTO);
    }
}
