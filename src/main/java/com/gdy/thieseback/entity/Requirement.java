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
@ApiModel("招聘要求类")
public class Requirement {
    @Id
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "性别")
    public Integer gender;

    @ApiModelProperty(value = "专业")
    public String major;

    @ApiModelProperty(value = "具体要求内容")
    public String content;

    @ApiModelProperty(value = "要求学历")
    public String degree;

    @ApiModelProperty(value = "最低毕业年份")
    public Date minYear;

    @ApiModelProperty(value = "最高毕业年份")
    public Date maxYear;

}
