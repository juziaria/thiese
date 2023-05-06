package com.gdy.thieseback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Recruit extends BaseEntity implements Serializable {

    @JsonIgnore
    @ApiModelProperty(value = "自动排序")
    private Integer id;

    @JsonIgnore
    @ApiModelProperty(value = "社会信用代码")
    private String scc;

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

    @ApiModelProperty(value = "状态")
    private Integer flag;

    @ApiModelProperty(value = "岗位要求")
    private String demand;

    @ApiModelProperty(value = "岗位薪资")
    private String salary;

    @ApiModelProperty(value = "岗位描述")
    private String description;

    @ApiModelProperty(value = "招聘人数")
    private Integer number;

    @ApiModelProperty(value = "投递说明")
    private String delivery_description;

    @ApiModelProperty(value = "岗位名称")
    private String jobName;

    @ApiModelProperty(value = "有效期")
    private Date availbleTime;

    @ApiModelProperty(value = "学历")
    private String degree;

    @ApiModelProperty(value = "薪资待遇")
    private String welfare;
}
