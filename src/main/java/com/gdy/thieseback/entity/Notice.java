package com.gdy.thieseback.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Data
@Setter
@Getter
@TableName(value = "notice")
public class Notice extends BaseEntity implements Serializable {
    @ApiModelProperty(value = "主键")
    private int id;

    @ApiModelProperty(value = "通知类型")
    private Integer type;

    @ApiModelProperty(value = "发布时间")
    private Date publishTime;

    @ApiModelProperty(value = "发布单位")
    private String collage;

    @ApiModelProperty(value = "题目")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "通知状态")
    private int flag;

    @ApiModelProperty(value = "通知附件")
    private String documentId;
}
