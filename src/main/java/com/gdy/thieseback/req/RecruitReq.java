package com.gdy.thieseback.req;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gdy.thieseback.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Data
public class RecruitReq {

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

    @Schema(description = "专业id列表")
    private List<String> majorIds;
    @Schema(description = "先别")
    private List<String> recruitIds;

    @ApiModelProperty(value = "联系方式")
    private String contactInfo;

    @ApiModelProperty(value = "办公地址")
    private String address;

    @ApiModelProperty(value = "状态")
    private Integer flag;

    /**
     * 分页大小
     */
    @Schema(description = "分页大小")
    @NotNull
    private Integer pageSize = 1;


    /**
     * 页码
     */
    @Schema(description = "页码")
    @NotNull
    private Integer pageNum = 1;



}
