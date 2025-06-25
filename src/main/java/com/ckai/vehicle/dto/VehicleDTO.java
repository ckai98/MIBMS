package com.ckai.vehicle.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class VehicleDTO {
    // /**
    //  *
    //  */
    // @NotNull(message="[]不能为空")
    // @ApiModelProperty("id")
    // private Long id;
    /**
     * 车辆识别码
     */
    @NotBlank(message="[车辆识别码]不能为空")
    @Size(max= 16,message="编码长度不能超过32")
    @ApiModelProperty("车辆识别码")
    @Length(max= 16,message="编码长度不能超过32")
    private String vid;
    /**
     * 电池类型
     */
    @NotNull(message="[电池类型]不能为空")
    @ApiModelProperty("电池类型")
    private Integer batteryType;
    /**
     * 总里程(km)
     */
    @NotNull(message="[总里程(km)]不能为空")
    @ApiModelProperty("总里程(km)")
    private BigDecimal totalMileage;
    /**
     * 电池健康状态(%)
     */
    @NotNull(message="[电池健康状态(%)]不能为空")
    @ApiModelProperty("电池健康状态(%)")
    private BigDecimal batteryHealth;
}
