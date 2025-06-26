package com.ckai.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Data
public class BatterySignalDTO {
    @NotBlank(message="[车辆识别码]不能为空")
    @Size(max= 32,message="编码长度不能超过32")
    @ApiModelProperty("车辆识别码")
    @Length(max= 32,message="编码长度不能超过32")
    private String vid;
    /**
     * 最小值
     */
    @NotNull(message="[最小值]不能为空")
    @ApiModelProperty("最小值")
    @JsonProperty("Mi")
    private BigDecimal Mi;
    /**
     * 最大值
     */
    @NotNull(message="[最大值]不能为空")
    @ApiModelProperty("最大值")
    @JsonProperty("Mx")
    private BigDecimal Mx;
    /**
     * 最小值
     */
    @NotNull(message="[最小值]不能为空")
    @ApiModelProperty("最小值")
    @JsonProperty("Ii")
    private BigDecimal Ii;
    /**
     * 最大值
     */
    @NotNull(message="[最大值]不能为空")
    @ApiModelProperty("最大值")
    @JsonProperty("Ix")
    private BigDecimal Ix;

}
