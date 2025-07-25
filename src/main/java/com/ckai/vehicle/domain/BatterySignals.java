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
* @TableName battery_signals
*/
@Data
public class BatterySignals implements Serializable {

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
    // /**
    // * 规则编号
    // */
    // @NotNull(message="[规则编号]不能为空")
    // @ApiModelProperty("规则编号")
    // private Integer ruleId;
    /**
    * 最小值
    */
    @NotNull(message="[最小值]不能为空")
    @ApiModelProperty("最小值")
    private BigDecimal Mi;
    /**
    * 最大值
    */
    @NotNull(message="[最大值]不能为空")
    @ApiModelProperty("最大值")
    private BigDecimal Mx;
    /**
     * 最小值
     */
    @NotNull(message="[最小值]不能为空")
    @ApiModelProperty("最小值")
    private BigDecimal Ii;
    /**
     * 最大值
     */
    @NotNull(message="[最大值]不能为空")
    @ApiModelProperty("最大值")
    private BigDecimal Ix;

    /**
    *
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private LocalDateTime createTime;


}
