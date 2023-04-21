package com.gdy.thieseback.controller;

import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.dto.Register;
import com.gdy.thieseback.entity.Company;
import com.gdy.thieseback.service.ICompanyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gdy/company/Info")
@Api(tags = "企业信息")
public class CompanyInfoController {
    @Autowired
    public ICompanyInfoService baseService;

    @ApiOperation("注册")
    @PostMapping("/register")
    public String Register(@RequestBody Register registerDto){
        return baseService.Register(registerDto);
    }

    @ApiOperation("登录")
    @GetMapping("/login")
    public Company Login(@RequestParam Long scc,@RequestParam String pwd){
        return baseService.Login(scc, pwd);
    }

    @ApiOperation("更改密码")
    @PostMapping("/changePwd")
    public String changePwd (@RequestBody ChangePwdDto changePwdDto){
        return baseService.changePwd(changePwdDto);
    }

    @ApiOperation("更改个人信息")
    @PostMapping("/modifiedInfo")
    public Company modifiedInfo(@RequestBody Company comInfo){
        return baseService.modifiedInfo(comInfo);
    }





}
