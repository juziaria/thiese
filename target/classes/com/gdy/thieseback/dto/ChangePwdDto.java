package com.gdy.thieseback.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@ApiModel("更改密码")
@NoArgsConstructor
@AllArgsConstructor
public class ChangePwdDto implements Serializable {


    @TableId
    @ApiModelProperty(value = "社会信用代码/学号")
    private String id;

    @ApiModelProperty(value = "旧密码")
    private String oldPwd;

    @ApiModelProperty(value = "新密码")
    private String newPwd;
}
