package com.ckai.vehicle.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
*
* @TableName warning_rules
*/
@Data
public class WarningRules implements Serializable {

    /**
    *
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 规则编号（电压差报警、电流差报警）
    */
    @NotNull(message="[规则编号（电压差报警、电流差报警）]不能为空")
    @ApiModelProperty("规则编号（电压差报警、电流差报警）")
    private Integer ruleId;
    /**
    * 电池类型
    */
    @NotNull(message="[电池类型]不能为空")
    @ApiModelProperty("电池类型")
    private Integer batteryType;
    /**
    * 区间判断最小值（包含
    */
    @NotNull(message="[区间判断最小值（包含]不能为空")
    @ApiModelProperty("区间判断最小值（包含")
    private BigDecimal minValue;
    /**
    * 区间判断最大值（不包含）
    */
    @NotNull(message="[区间判断最大值（不包含）]不能为空")
    @ApiModelProperty("区间判断最大值（不包含）")
    private BigDecimal maxValue;
    /**
    * 预警等级（0-4，NULL=不报警）
    */
    @ApiModelProperty("预警等级（0-4，NULL=不报警）")
    private Integer warningLevel;
    /**
    *
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private LocalDateTime createTime;
    /**
    *
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private LocalDateTime updateTime;



}
