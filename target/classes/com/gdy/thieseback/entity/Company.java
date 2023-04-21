package com.gdy.thieseback.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("企业实体类")
public class Company extends BaseEntity implements Serializable {

    @TableId
    @Nullable
    @ApiModelProperty(value = "社会信用代码")
    private String scc;

    @JsonIgnore
    @ApiModelProperty(value ="公司密码")
    private String companyPwd;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "公司电话")
    private String companyPhone;

    @ApiModelProperty(value = "公司邮箱")
    private String companyEmail;

    @ApiModelProperty(value = "公司地址")
    private String address;

    @ApiModelProperty(value = "公司图像")
    private String sign;

    @ApiModelProperty(value = "公司负责人")
    private String principal;

    @ApiModelProperty(value = "负责人身份证")
    private String identity;

    @JsonIgnore
    @ApiModelProperty(value = "盐值")
    private String salt;
}