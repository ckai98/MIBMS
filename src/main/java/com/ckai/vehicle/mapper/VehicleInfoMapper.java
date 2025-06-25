package com.ckai.vehicle.mapper;

import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.dto.VehiclePageQueryDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VehicleInfoMapper {

    @Insert("insert into vehicle_info(vid,battery_type,total_mileage,battery_health,create_time,update_time) values(#{vid},#{batteryType},#{totalMileage},#{batteryHealth},#{createTime},#{updateTime})")
    void insert(VehicleInfo vehicleInfo);

    void update(VehicleInfo vehicleInfo);

    @Select("select * from vehicle_info where id = #{id}")
    VehicleInfo getById(Long id);

    Page<VehicleInfo> pageQuery(VehiclePageQueryDTO vehiclePageQueryDTO);
}
