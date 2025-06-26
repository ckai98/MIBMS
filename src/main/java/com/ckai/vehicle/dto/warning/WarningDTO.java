package com.ckai.vehicle.dto.warning;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class WarningDTO {
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
}
