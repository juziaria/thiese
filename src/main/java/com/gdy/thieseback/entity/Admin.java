package com.gdy.thieseback.entity;

import com.gdy.thieseback.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.mybatis.spring.annotation.MapperScan;
import java.io.Serializable;

@Data
@ApiModel("管理员实体类")
public class Admin extends BaseEntity implements Serializable {
    @Id
    @ApiModelProperty(value = "管理员账号")
    private String id;

    @ApiModelProperty(value = "管理员登录名")
    private String name;

    @ApiModelProperty(value = "管理员密码")
    private String pwd;

    @ApiModelProperty(value = "是否删除")
    private Integer flag;

}
