package com.gdy.thieseback.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("工作经历")
public class Experience {
    @Id
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "公司")
    private Integer companyId;

    @ApiModelProperty(value = "工作状态")
    private Integer employmentId;

    @ApiModelProperty(value = "薪水")
    private Integer salary;

    @ApiModelProperty(value = "工作性质")
    private Integer workProperty;

    @ApiModelProperty(value = "工作地点")
    private String workPlace;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "工作内容")
    private String workContent;

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    @ApiModelProperty(value = "技术")
    private Integer technologyId;

    @ApiModelProperty(value = "工作地点性质")
    private Integer placeProperty;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "公司性质")
    private Integer companyProperty;

    @ApiModelProperty(value = "评价")
    private String evaluation;

    @ApiModelProperty(value = "是否删除")
    private Integer flag;
}

