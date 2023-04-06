package com.gdy.thieseback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel("实体类的基类")
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    @JsonIgnore
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    @JsonIgnore
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty(value = "最后修改执行人")
    private Long modifiedUser;

    @JsonIgnore
    @ApiModelProperty(value = "最后修改时间")
    private Date modifiedTime;

    @JsonIgnore
    @ApiModelProperty(value = "是否删除")
    private Integer deleted;
}
