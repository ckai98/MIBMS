package com.ckai.vehicle.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class WarningRuleDTO {
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
}
