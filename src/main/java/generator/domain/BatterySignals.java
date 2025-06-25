package generator.domain;

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
* @TableName battery_signals
*/
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
    /**
    * 规则编号
    */
    @NotNull(message="[规则编号]不能为空")
    @ApiModelProperty("规则编号")
    private Integer ruleId;
    /**
    * 最小值
    */
    @NotNull(message="[最小值]不能为空")
    @ApiModelProperty("最小值")
    private BigDecimal min;
    /**
    * 最大值
    */
    @NotNull(message="[最大值]不能为空")
    @ApiModelProperty("最大值")
    private BigDecimal max;
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
    * 规则编号
    */
    private void setRuleId(Integer ruleId){
    this.ruleId = ruleId;
    }

    /**
    * 最小值
    */
    private void setMin(BigDecimal min){
    this.min = min;
    }

    /**
    * 最大值
    */
    private void setMax(BigDecimal max){
    this.max = max;
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
    * 规则编号
    */
    private Integer getRuleId(){
    return this.ruleId;
    }

    /**
    * 最小值
    */
    private BigDecimal getMin(){
    return this.min;
    }

    /**
    * 最大值
    */
    private BigDecimal getMax(){
    return this.max;
    }

    /**
    * 
    */
    private Date getCreateTime(){
    return this.createTime;
    }

}
