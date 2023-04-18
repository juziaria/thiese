package com.gdy.thieseback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Recruit extends BaseEntity implements Serializable {

    @JsonIgnore
    @ApiModelProperty(value = "自动排序")
    private Integer id;

    @JsonIgnore
    @ApiModelProperty(value = "社会信用代码")
    private Long scc;

    @ApiModelProperty(value = "企业名称")
    private String companyName;

    @ApiModelProperty(value = "企业名称")
    private String recruitContext;

    @ApiModelProperty(value = "专业")
    private List<String> major;

    @ApiModelProperty(value = "联系方式")
    private String contactInfo;

    @ApiModelProperty(value = "办公地址")
    private String address;
}
