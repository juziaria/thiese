package com.gdy.thieseback.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.gdy.thieseback.util.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class StuInfoDto extends PageQuery implements Serializable {
    @ExcelProperty("学号")
    @ApiModelProperty(value = "学号")
    private Long id;

    @ExcelProperty("学生身份证号码")
    @ApiModelProperty(value = "学生身份证号码")
    private Long studentIdentity;

    @ExcelProperty("学生姓名")
    @ApiModelProperty(value = "学生姓名")
    private String studentName;

    @ExcelProperty("密码")
    @ApiModelProperty(value = "学生密码")
    private String studentPwd;

    @ExcelProperty("是否删除")
    @ApiModelProperty(value = "是否删除")
    private Integer deleted;

    @ExcelProperty("学院")
    @ApiModelProperty(value = "学院")
    private String college;

    @ExcelProperty("年级")
    @ApiModelProperty(value = "年级")
    private Integer grade;

    @ExcelProperty("班级")
    @ApiModelProperty(value = "班级")
    private Integer studentClass;

    @ExcelProperty("专业")
    @ApiModelProperty(value = "专业")
    private String major;

    @ExcelProperty("电话")
    @ApiModelProperty(value = "学生电话号码")
    private String studentPhone;

    @ExcelProperty("邮箱")
    @ApiModelProperty(value = "学生邮箱")
    private String studentEmail;

    @ExcelProperty("性别")
    @ApiModelProperty(value = "学生性别")
    private String studentGender;

    @ApiModelProperty(value = "创建人")
    private Long createUser;


    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    @ApiModelProperty(value = "最后修改执行人")
    private Long modifiedUser;


    @ApiModelProperty(value = "最后修改时间")
    private Date modifiedTime;


}
