package com.gdy.thieseback.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("学生展示信息")
public class StuInfo{
    private String id;

    private String studentIdentity;

    private String studentName;

    private String collage;

    private Integer grade;

    private Integer studentClass;

    private String major;

    private String studentPhone;

    private String studentEmail;

    private String studentGender;

    private String employment;


}
