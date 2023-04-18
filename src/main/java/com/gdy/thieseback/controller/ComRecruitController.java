package com.gdy.thieseback.controller;

import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.service.IComRecruitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gdy/company/Recruit")
@Api(tags = "企业信息")
public class ComRecruitController {

    @Autowired
    public IComRecruitService baseService;

    @ApiOperation("发布招聘信息")
    @PostMapping("/publish")
    public Recruit publish(@RequestBody Recruit recruit){
        return baseService.publish(recruit);
    }


}
