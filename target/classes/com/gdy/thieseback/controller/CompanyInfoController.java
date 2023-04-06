package com.gdy.thieseback.controller;

import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.dto.RegisterDto;
import com.gdy.thieseback.entity.Company;
import com.gdy.thieseback.serive.ICompanyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gdy/companyInfo")
@Api(tags = "企业端")
public class CompanyInfoController {
    @Autowired
    public ICompanyInfoService baseService;

    @ApiOperation("注册")
    @PostMapping("/register")
    public String Register(@RequestBody RegisterDto registerDto){
        return baseService.Register(registerDto);
    }

    @ApiModelProperty("登录")
    @PostMapping("/login")
    public Company Login(@RequestParam Long scc,@RequestParam String pwd){
        return baseService.Login(scc, pwd);
    }

    @ApiModelProperty("更改密码")
    @PostMapping("/changePwd")
    public String changePwd (@RequestBody ChangePwdDto changePwdDto){
        return baseService.changePwd(changePwdDto);
    }

    @ApiModelProperty("更改个人信息")
    @PostMapping("/modifiedInfo")
    public Company modifiedInfo(@RequestBody Company comInfo){
       Company a = comInfo;
        return baseService.modifiedInfo(comInfo);
    }


}
