package com.gdy.thieseback.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.MeetingInfo;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.myEnum.FlagEnum;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
     *分配教室，并发布
     */
    Boolean EnsureMeeting(Integer id, Integer classroomId);

}
