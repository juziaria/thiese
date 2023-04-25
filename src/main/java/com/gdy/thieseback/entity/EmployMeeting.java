package com.gdy.thieseback.entity;import io.swagger.annotations.ApiModel;import io.swagger.annotations.ApiModelProperty;import lombok.AllArgsConstructor;import lombok.Data;import lombok.EqualsAndHashCode;import lombok.NoArgsConstructor;import java.io.Serializable;import java.util.Date;@EqualsAndHashCode(callSuper = true)@AllArgsConstructor@NoArgsConstructor@Data@ApiModel("双选会、宣讲会")public class EmployMeeting extends BaseEntity implements Serializable {    @ApiModelProperty(value = "id")    private Integer id;    @ApiModelProperty(value = "时间")    private Date time;    @ApiModelProperty(value = "双选会名称")    private String name;    @ApiModelProperty(value = "主办方")    private String master;    @ApiModelProperty(value = "地址")    private String place;    @ApiModelProperty(value = "展位数量")    private int amount;    @ApiModelProperty(value = "专业")    private String major;    @ApiModelProperty(value = "0-宣讲会1-双选会")    private Integer type;    @ApiModelProperty(value = "状态")    private Integer flag;    @Override    public String toString() {        return "EmployMeeting{" +                "name='" + name + '\'' +                ", master='" + master + '\'' +                ", place='" + place + '\'' +                ", amount=" + amount +                ", major='" + major + '\'' +                ", type='" + type + '\'' +                ", id='" + id + '\'' +                ", state=" + flag +                '}';    }}