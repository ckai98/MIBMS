package com.ckai.vehicle.mapper;

import com.ckai.vehicle.domain.BatterySignals;
import com.ckai.vehicle.dto.BatterySignalDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BatterySignalMapper {
    @Insert("insert into battery_signals(vid,Mi,Mx,Ii,Ix,create_time) values(#{vid},#{Mi},#{Mx},#{Ii},#{Ix},#{createTime})")
    void insert(BatterySignals batterySignals);

    List<BatterySignals> getRecentSignalReports(@Param("since") LocalDateTime since);
}
