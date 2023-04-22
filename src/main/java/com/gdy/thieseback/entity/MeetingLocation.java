package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MeetingLocation {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "地点性质")
    private Integer format;

    @ApiModelProperty(value = "最大容纳数量")
    private Integer maxCount;

    @ApiModelProperty(value = "位置名")
    private String name;

    @ApiModelProperty(value = "是否被使用")
    private Integer flag;
}
