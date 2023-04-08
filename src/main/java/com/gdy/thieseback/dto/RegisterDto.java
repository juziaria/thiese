package com.gdy.thieseback.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterDto implements Serializable {

    @TableId
    @ApiModelProperty(value = "社会信用代码")
    private Long scc;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value ="公司密码")
    private String companyPwd;
}
