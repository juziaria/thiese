package com.gdy.thieseback.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gdy.thieseback.dto.StuInfoDto;
import com.gdy.thieseback.service.IAdminStuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/gdy/admin/manageInfo")
@Api(tags = "管理企业与学生信息")
public class AdminInfoStuController {

    @Autowired
    public IAdminStuInfoService baseService;


    @ApiOperation("导入学生个人信息")
    @PostMapping("/import")
    public String  importStuInfo(@RequestParam MultipartFile file){
        return baseService.importStuInfo(file);
    }

    @ApiOperation("学生信息展示")
    @PostMapping("/getPage")
    public IPage<StuInfoDto> getPage(@RequestBody StuInfoDto stuInfoDto) {
        //return baseService.getPage();
        return  null;
    }





}
