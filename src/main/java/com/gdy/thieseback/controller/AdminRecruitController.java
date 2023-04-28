package com.gdy.thieseback.controller;


import com.gdy.thieseback.entity.Parameter;
import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.service.IAdminRecruitService;
import com.gdy.thieseback.util.Conversation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 管理员控制层_招聘信息
 */
@RestController
@RequestMapping("/gdy/admin/recruit")
@Api(tags = "管理员端")
public class AdminRecruitController {
    @Autowired
    private IAdminRecruitService iAdminRecruitService;

    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();



    @ApiOperation("返回公司列表")
    @GetMapping("/selectCompanyName")
    public HashMap<String, String> selectCompanyName(){
        return iAdminRecruitService.selectCompanyName();
    }

    @ApiOperation("浏览招聘信息")
    @GetMapping("/recruitmentShow")
    public List<Recruit> recruitmentShow(@RequestParam String flagContent,
                                         @RequestParam String companyScc){
        FlagEnum flagEnum = null;

        if(flagContent != null && !flagContent.equals("")){
            flagEnum = FlagEnum.find(flagContent);
        }

        return iAdminRecruitService.recruitmentShow(flagEnum, companyScc);
    }

    @ApiOperation("驳回")
    @GetMapping("/rejectRecruitment")
    public Boolean rejectRecruitment(@RequestParam Integer id){
        return iAdminRecruitService.updateRecruitmentFlag(id, FlagEnum.Reject);
    }

    @ApiOperation("结束")
    @GetMapping("/endRecruitment")
    public Boolean endRecruitment(@RequestParam Integer id){
        return iAdminRecruitService.updateRecruitmentFlag(id, FlagEnum.End);
    }

    @ApiOperation("发布")
    @GetMapping("/publishRecruitment")
    public Boolean publishRecruitment(@RequestParam Integer id){
        return iAdminRecruitService.updateRecruitmentFlag(id, FlagEnum.Publish);
    }

}
