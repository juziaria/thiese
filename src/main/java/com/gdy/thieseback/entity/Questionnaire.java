package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Questionnaire {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "年级")
    private Integer grade;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "建议")
    private String advice;
}
