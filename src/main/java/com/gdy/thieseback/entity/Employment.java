package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("就业状态")
public class Employment {
    @Id
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "学生ID")
    private String studentId;

    @ApiModelProperty(value = "工作现状")
    private Integer employmentStatus;

    @ApiModelProperty(value = "是否删除")
    private Integer flag;
}
