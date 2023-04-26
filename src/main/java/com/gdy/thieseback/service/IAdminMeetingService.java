package com.gdy.thieseback.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.MeetingInfo;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.myEnum.FlagEnum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface IAdminMeetingService extends IService<Admin> {
    /**
     *浏览会议信息
     */
    List<MeetingInfo> showMeeting(FlagEnum flagEnum);
    /**
     *删除会议信息
     */
    void deleteMeeting(Integer id);
    /**
     *添加招聘会
     */
    Boolean AddMeeting(MeetingInfo meetingInfo);

}
