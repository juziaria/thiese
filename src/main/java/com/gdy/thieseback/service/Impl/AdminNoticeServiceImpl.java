package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Notice;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.myEnum.NoticeTypeEnum;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.service.IAdminNoticeService;
import com.gdy.thieseback.util.Conversation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
//@Transactional
public class AdminNoticeServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminNoticeService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();


    @Override
    public List<Notice> selectNotice(Integer id, FlagEnum flagEnum) {
        if (flagEnum == null){
            return adminMapper.selectNotices_1(id, null);
        }
        else {
            return adminMapper.selectNotices_1(id, flagEnum.getCode());
        }
    }

    @Override
    public List<Notice> selectNotice(NoticeTypeEnum noticeTypeEnum,
                                     String name,
                                     Integer Day,
                                     FlagEnum flagEnum) {
        Date now = new Date();
        Date last = new Date(Day);

        return adminMapper.selectNotices_2(noticeTypeEnum.getCode(), name, now, last, flagEnum.getCode());
    }

    @Override
    public Integer insertNotice(Notice notice) {
        return adminMapper.insertNotice(notice);
    }

    @Override
    public Boolean updateNoticeState(Integer id, FlagEnum flagEnum) {
        return adminMapper.updateNoticeFlag(id, flagEnum.getCode());
    }

    @Override
    public Boolean updateNotice(Notice notice) {
        return adminMapper.updateNotice(notice);
    }
}
