package com.gdy.thieseback.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends BaseEntity implements Serializable {

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

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ExcelProperty("电话")
    @ApiModelProperty(value = "学生电话号码")
    private String studentPhone;

    @ExcelProperty("邮箱")
    @ApiModelProperty(value = "学生邮箱")
    private String studentEmail;

    @ExcelProperty("性别")
    @ApiModelProperty(value = "学生性别")
    private String studentGender;

//    @ExcelProperty("头像")
//    @ApiModelProperty(value = "头像")
//    private String studentHeadShot;
}
