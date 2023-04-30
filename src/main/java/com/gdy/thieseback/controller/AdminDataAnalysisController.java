package com.gdy.thieseback.controller;


import com.gdy.thieseback.entity.Parameter;
import com.gdy.thieseback.service.IAdminDataAnalysisService;
import com.gdy.thieseback.service.IAdminRecruitService;
import com.gdy.thieseback.util.Conversation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员控制层_数据分析
 */
@RestController
@RequestMapping("/gdy/admin/dataAnalysis")
@Api(tags = "管理员端")
public class AdminDataAnalysisController {
    @Autowired
    private IAdminDataAnalysisService iAdminDataAnalysisService;

    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();

    @ApiOperation("下载文件")
    @GetMapping("/CountMeetingType")
    public void CountMeetingType(@RequestParam Integer year){
        iAdminDataAnalysisService.CountMeetingType(year);

    }

}
