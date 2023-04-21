package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("企业实体类")
public class Company extends BaseEntity implements Serializable {
     @Id
     @ApiModelProperty(value = "公司账号")
     private String id;

     @ApiModelProperty(value ="公司密码")
     private String pwd;

     @ApiModelProperty(value = "公司名称")
     private String name;

     @ApiModelProperty(value = "公司电话")
     private String phone;

     @ApiModelProperty(value = "公司邮箱")
     private String email;

     @ApiModelProperty(value = "公司地址")
     private String address;

     @ApiModelProperty(value = "公司创建时间")
     private Date createTime;

     @ApiModelProperty(value = "招聘负责人")
     private String curator;

     @ApiModelProperty(value = "是否删除")
     private Integer flag;

}

