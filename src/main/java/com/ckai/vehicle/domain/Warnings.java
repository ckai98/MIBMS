package com.ckai.vehicle.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
*
* @TableName warnings
*/
public class Warnings implements Serializable {

    /**
    *
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 车辆识别码
    */
    @NotBlank(message="[车辆识别码]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("车辆识别码")
    @Length(max= 32,message="编码长度不能超过32")
    private String vid;
    /**
    * 电池类型
    */
    @NotNull(message="[电池类型]不能为空")
    @ApiModelProperty("电池类型")
    private Integer batteryType;
    /**
    * 使用的规则编号
    */
    @NotNull(message="[使用的规则编号]不能为空")
    @ApiModelProperty("使用的规则编号")
    private Integer ruleId;
    /**
    * 预警等级（0~4）
    */
    @NotNull(message="[预警等级（0~4）]不能为空")
    @ApiModelProperty("预警等级（0~4）")
    private Integer warnLevel;
    /**
    * 触发值
    */
    @NotNull(message="[触发值]不能为空")
    @ApiModelProperty("触发值")
    private BigDecimal triggerValue;
    /**
    * 是否已处理：0-否，1-是
    */
    @NotNull(message="[是否已处理：0-否，1-是]不能为空")
    @ApiModelProperty("是否已处理：0-否，1-是")
    private Integer isHandled;
    /**
    *
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Date createTime;

    /**
    *
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 车辆识别码
    */
    private void setVid(String vid){
    this.vid = vid;
    }

    /**
    * 电池类型
    */
    private void setBatteryType(Integer batteryType){
    this.batteryType = batteryType;
    }

    /**
    * 使用的规则编号
    */
    private void setRuleId(Integer ruleId){
    this.ruleId = ruleId;
    }

    /**
    * 预警等级（0~4）
    */
    private void setWarnLevel(Integer warnLevel){
    this.warnLevel = warnLevel;
    }

    /**
    * 触发值
    */
    private void setTriggerValue(BigDecimal triggerValue){
    this.triggerValue = triggerValue;
    }

    /**
    * 是否已处理：0-否，1-是
    */
    private void setIsHandled(Integer isHandled){
    this.isHandled = isHandled;
    }

    /**
    *
    */
    private void setCreateTime(Date createTime){
    this.createTime = createTime;
    }


    /**
    *
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 车辆识别码
    */
    private String getVid(){
    return this.vid;
    }

    /**
    * 电池类型
    */
    private Integer getBatteryType(){
    return this.batteryType;
    }

    /**
    * 使用的规则编号
    */
    private Integer getRuleId(){
    return this.ruleId;
    }

    /**
    * 预警等级（0~4）
    */
    private Integer getWarnLevel(){
    return this.warnLevel;
    }

    /**
    * 触发值
    */
    private BigDecimal getTriggerValue(){
    return this.triggerValue;
    }

    /**
    * 是否已处理：0-否，1-是
    */
    private Integer getIsHandled(){
    return this.isHandled;
    }

    /**
    *
    */
    private Date getCreateTime(){
    return this.createTime;
    }

}
