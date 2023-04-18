package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("正式岗位、实习岗位")
public class EmployPosition extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "有效期")
    private Date availbletime;

    @ApiModelProperty(value = "岗位名称")
    private String jobname;

    @ApiModelProperty(value = "公司名称")
    private String comname;

    @ApiModelProperty(value = "工作地点")
    private String workplace;

    @ApiModelProperty(value = "相关专业")
    private String major;


    @ApiModelProperty(value = "学历")
    private String degree;


    @ApiModelProperty(value = "0-实习岗位 1-正式岗位")
    private String pay;

    @ApiModelProperty(value = "id")
    private String id;


    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "状态")
    private String flag;

    public Date getAvailbletime() {
        return availbletime;
    }

    public void setAvailbletime(Date availbletime) {
        this.availbletime = availbletime;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }



    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "EmployPosition{" +
                "availbletime=" + availbletime +
                ", jobname='" + jobname + '\'' +
                ", comname='" + comname + '\'' +
                ", workplace='" + workplace + '\'' +
                ", major='" + major + '\'' +
                ", degree='" + degree + '\'' +
                ", pay='" + pay + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
