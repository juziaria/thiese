package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Meeting {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "会议名")
    private String name;

    @ApiModelProperty(value = "公司")
    private String companyId;

    @ApiModelProperty(value = "地点性质")
    private Integer meetingFormat;

    @ApiModelProperty(value = "地点")
    private Integer classroomId;

    @ApiModelProperty(value = "面向专业")
    private String major;

    @ApiModelProperty(value = "会议类型")
    private Integer meetingType;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "状态")
    private Integer flag;
}
