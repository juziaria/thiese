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
@ApiModel("双选会")
public class EmployDoubleMeeting extends BaseEntity implements Serializable {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "会议时间")
    private Date meetingtime;

    @ApiModelProperty(value = "面试时间")
    private Date interviewtime;

    @ApiModelProperty(value = "主办方")
    private String master;

    @ApiModelProperty(value = "会议名称")
    private String name;

    @ApiModelProperty(value = "会议地点")
    private String place;

    @ApiModelProperty(value = "相关专业")
    private String major;

    @ApiModelProperty(value = "展位数量")
    private String amount;

    @ApiModelProperty(value = "状态")
    private Integer flag;


    @Override
    public String toString() {
        return "EmployDoubleMeeting{" +
                "id=" + id +
                ", meetingtime=" + meetingtime +
                ", interviewtime=" + interviewtime +
                ", meetingmaster='" + master + '\'' +
                ", meetingname='" + name + '\'' +
                ", meetingplace='" + place + '\'' +
                ", major='" + major + '\'' +
                ", amount='" + amount + '\'' +
                ", flag=" + flag +
                '}';
    }



}
