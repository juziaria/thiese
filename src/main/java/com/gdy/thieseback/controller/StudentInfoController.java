package com.gdy.thieseback.controller;

import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.entity.Student;
import com.gdy.thieseback.service.IStudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gdy/studentInfo")
@Api(tags = "学生信息")
public class StudentInfoController {

    @Autowired
    public IStudentInfoService baseService;

    @ApiOperation("登录")
    @GetMapping("/login")
    public Student login(@RequestParam Long id,@RequestParam String studentPwd){
        return  baseService.login(id, studentPwd);
    }

    @ApiOperation("修改密码")
    @PostMapping("/changePwd")
    public String changePwd(@RequestBody ChangePwdDto changePwdDto){
        return  baseService.changePwd(changePwdDto);
    }

    @ApiOperation("修改个人信息")
    @PostMapping("/login")
    public Student stuInfo(@RequestBody Student student){
        return  baseService.stuInfo(student);
    }

}
