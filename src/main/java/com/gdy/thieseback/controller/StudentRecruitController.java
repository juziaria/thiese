package com.gdy.thieseback.controller;

import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.service.StudentRecruitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 学生控制层_招聘信息
 */
@RestController
@RequestMapping("/gdy/stu/recruit")
@Api(tags = "学生端")
public class StudentRecruitController {

    @Autowired
    private StudentRecruitService studentRecruitService;
    /**
     * 详细招聘岗位
     * @return
     */
    @ApiOperation("详细招聘岗位")
    @GetMapping(value = "/details")
    private Recruit getRecruitDetail(Recruit recruit){

       return studentRecruitService.recruitmentShow(recruit);
    }
}
