package com.gdy.thieseback.controller;

import com.gdy.thieseback.entity.EmployDoubleMeeting;
import com.gdy.thieseback.req.EmployDoubleMeetingReq;
import com.gdy.thieseback.req.EmployPositionReq;
import com.gdy.thieseback.resp.CommonResp;
import com.gdy.thieseback.resp.PageResp;
import com.gdy.thieseback.service.EmployDoubleMeetingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController =@RequestBody+@Controller
 * 双选会
 * */
@RestController
@RequestMapping("/gdy/employ_position")
@Api(tags = "正式岗位")
public class EmployDoubleMeetingController {
    @Autowired
    private EmployDoubleMeetingService employDoubleMeetingService;

    /**
     *根据employ_position判断宣讲会的会议日期，会议名字，
     * 召开场所，专业需求，学历要求前端根据字段进行判断
     *
     *
     * */
    @GetMapping("/getlist")
    public CommonResp getList(EmployDoubleMeetingReq employDoubleMeetingReq){

        CommonResp<PageResp<EmployDoubleMeeting>> resp = new CommonResp<>();
        PageResp<EmployDoubleMeeting> list = employDoubleMeetingService.getList(employDoubleMeetingReq);
        resp.setContent(list);
        return resp;


    }
}
