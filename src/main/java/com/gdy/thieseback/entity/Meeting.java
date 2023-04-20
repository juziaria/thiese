package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Meeting {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "会议名")
    private String name;

    @ApiModelProperty(value = "公司")
    private String companyId;

    @ApiModelProperty(value = "地点性质")
    private Integer placeType;

    @ApiModelProperty(value = "地点")
    private String place;

    @ApiModelProperty(value = "数量")
    private Integer amount;

    @ApiModelProperty(value = "面向专业")
    private String major;

    @ApiModelProperty(value = "会议类型")
    private Integer meetingType;

    @ApiModelProperty(value = "状态")
    private Integer flag;
}
