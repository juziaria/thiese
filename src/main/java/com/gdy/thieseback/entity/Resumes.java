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
@ApiModel("简历")
public class Resumes {
    @Id
    @ApiModelProperty(value = "编号")
    private Integer id;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "拓展名")
    private String extension;

    @ApiModelProperty(value = "是否删除")
    private Integer flag;
}
