package com.gdy.thieseback.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel("企业展示信息")
public class CompanyInfoDto {

    private String id;

    private String name;

    private String phone;

    private String email;

    private String address;

    private String createTime;

    private String curator;
}
