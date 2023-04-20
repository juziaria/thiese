package com.gdy.thieseback.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("招聘信息类")
public class Recruitment {
    @Id
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "岗位")
    private String position;

    @ApiModelProperty(value = "工作内容")
    private String workContent;

    @ApiModelProperty(value = "薪水")
    private Integer salary;

    @ApiModelProperty(value = "工作地点")
    private String workPlace;

    @ApiModelProperty(value = "要求")
    private Integer requirementId;

    @ApiModelProperty(value = "公司")
    private String companyId;

    @ApiModelProperty(value = "截止时间")
    private Data endTime;

    @ApiModelProperty(value = "状态")
    public Integer flag;
}

