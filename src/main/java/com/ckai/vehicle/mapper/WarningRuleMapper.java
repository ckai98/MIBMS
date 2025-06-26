package com.ckai.vehicle.mapper;

import com.ckai.vehicle.domain.VehicleInfo;
import com.ckai.vehicle.domain.WarningRules;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WarningRuleMapper {
    @Insert("insert into warning_rules(id,rule_id,battery_type,min_value,max_value,warning_level,create_time,update_time) values(#{id},#{ruleId},#{batteryType},#{minValue},#{maxValue},#{warningLevel},#{createTime},#{updateTime})")
    void insert(WarningRules warningRules);

    void update(WarningRules warningRules);

    @Select("select * from warning_rules where id = #{id}")
    WarningRules getById(Long id);

    @Select("select * from warning_rules where battery_type = #{batteryType}")
    List<WarningRules> getByBatteryType(Integer batteryType);

    // @Select("select warning_level from warning_rules where battery_type = #{batteryType} and rule_id = #{warnId} and (min_value <= #{flag} and max_value > #{flag})")
    @Select("SELECT warning_level FROM warning_rules " +
            "WHERE battery_type = #{batteryType} " +
            "AND rule_id = #{ruleId} " +
            "AND (min_value <= #{flag} AND max_value > #{flag}) " +
            "LIMIT 1")
    Integer getLevel(@Param("batteryType") Integer batteryType,
                     @Param("ruleId") Integer ruleId,
                     @Param("flag") Double flag);
    // Integer getLevel(Integer batteryType, Integer warnId, Double flag);
}
