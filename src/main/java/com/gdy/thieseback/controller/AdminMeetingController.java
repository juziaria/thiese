package com.gdy.thieseback.controller;


import com.gdy.thieseback.dto.MeetingInfo;
import com.gdy.thieseback.entity.Parameter;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.service.IAdminMeetingService;
import com.gdy.thieseback.util.Conversation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员控制层_招聘会
 */
@RestController
@RequestMapping("/gdy/admin/meeting")
@Api(tags = "管理员端")
public class AdminMeetingController {
    @Autowired
    private IAdminMeetingService iAdminMeetingService;

    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();


    @ApiOperation("浏览未发布会议")
    @GetMapping("/showNotPublishMeeting")
    public List<MeetingInfo> showNotPublishMeeting(){
        return iAdminMeetingService.showMeeting(FlagEnum.NotPublish);
    }

    @ApiOperation("浏览发布，但未开始会议")
    @GetMapping("/showNotStartedMeeting")
    public List<MeetingInfo> showNotStartedMeeting(){
        return iAdminMeetingService.showMeeting(FlagEnum.NotStarted);
    }

    @ApiOperation("浏览正在进行的会议")
    @GetMapping("/showInProgressMeeting")
    public List<MeetingInfo> showInProgressMeeting(){
        return iAdminMeetingService.showMeeting(FlagEnum.InProgress);
    }

    @ApiOperation("浏览已结束的会议")
    @GetMapping("/showEndMeeting")
    public List<MeetingInfo> showEndMeeting(){
        return iAdminMeetingService.showMeeting(FlagEnum.End);
    }

    @ApiOperation("删除指定会议")
    @GetMapping("/deleteMeeting")
    public Boolean deleteMeeting(@RequestParam Integer id){
        try {
            iAdminMeetingService.deleteMeeting(id);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @ApiOperation("添加招聘会")
    @PostMapping("/RequestParam")
    public Boolean AddMeeting(@RequestBody MeetingInfo meetingInfo){
        return iAdminMeetingService.AddMeeting(meetingInfo);
    }
}
