package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("正式岗位、实习岗位")
public class EmployPosition extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "有效期")
    private Date availbletime;

    @ApiModelProperty(value = "岗位名称")
    private String jobname;

    @ApiModelProperty(value = "公司名称")
    private String comname;

    @ApiModelProperty(value = "工作地点")
    private String workplace;

    @ApiModelProperty(value = "相关专业")
    private String major;

    @ApiModelProperty(value = "学历")
    private String degree;

    @ApiModelProperty(value = "0-实习岗位 1-正式岗位")
    private String pay;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "状态")
    private Integer flag;

    @Override
    public String toString() {
        return "EmployPosition{" +
                "availbletime=" + availbletime +
                ", jobname='" + jobname + '\'' +
                ", comname='" + comname + '\'' +
                ", workplace='" + workplace + '\'' +
                ", major='" + major + '\'' +
                ", degree='" + degree + '\'' +
                ", pay='" + pay + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
