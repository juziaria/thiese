package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Meeting extends BaseEntity implements Serializable {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "会议名")
    private String name;

    @ApiModelProperty(value = "公司")
    private String companyScc;

    @ApiModelProperty(value = "地点")
    private Integer meetingLocationId;

    @ApiModelProperty(value = "面向专业")
    private String major;

    @ApiModelProperty(value = "会议类型")
    private Integer type;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "状态")
    private Integer flag;

}
