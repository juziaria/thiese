package com.gdy.thieseback.req;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Getter
@Setter
public class NoticeReq {
    @ApiModelProperty(value = "主键")
    private int id;

    @NotNull(message = "通知类型不能为空")
    @Schema(description = "类型（0 1 2 3 4 5）")
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

    @NotNull(message = "页码不能为空")
    private Integer pageNum;


    @NotNull(message = "页面大小不能为空")
    private Integer pageSize;
}
