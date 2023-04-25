package com.gdy.thieseback.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.dto.MeetingInfo;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.EmployMeeting;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminMeetingService;
import com.gdy.thieseback.service.IAdminNoticeService;
import com.gdy.thieseback.util.Conversation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminMeetingServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminMeetingService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();



    @Override
    public List<MeetingInfo> showMeeting(FlagEnum flagEnum) {
        List<EmployMeeting> meetingList = adminMapper.selectMeeting(flagEnum.getCode(), null);
        List<MeetingInfo> meetingInfoList = new ArrayList<>();

        //TODO

        return meetingInfoList;
    }

    @Override
    public void deleteMeeting(Integer id) {
        adminMapper.updateMeetingFlag(id, FlagEnum.Delete.getCode());
    }

    @Override
    public Boolean EnsureMeeting(Integer id, Integer classroomId) {
        return adminMapper.updateMeetingFlag(id, FlagEnum.NotStarted.getCode());
    }
}
