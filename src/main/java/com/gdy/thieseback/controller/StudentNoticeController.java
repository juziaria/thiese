package com.gdy.thieseback.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdy.thieseback.entity.Notice;
import com.gdy.thieseback.req.NoticeReq;
import com.gdy.thieseback.service.StudentNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学生控制层_通知信息
 */
@RestController
@RequestMapping("/gdy/stu/notice")
@Api(tags = "学生端通知信息")
public class StudentNoticeController {

    @Autowired
    @Resource
    private StudentNoticeService studentNoticeService;


    @ApiOperation("分页条件查询")
    @PostMapping("/getpage")
    public Page<Notice> Notice(@RequestBody @Validated NoticeReq noticeReq){
       return studentNoticeService.queryPage(noticeReq);
    }
}
