package com.gdy.thieseback.controller;

import com.gdy.thieseback.serive.IAdminStuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/gdy/admin/manageInfo")
@Api(tags = "管理企业与学生信息")
public class AdminInfoStuController {

    @Autowired
    public IAdminStuInfoService baseMapper;


    @ApiOperation("导入学生个人信息")
    @PostMapping("/import")
    public void importStuInfo(){

    }




}
