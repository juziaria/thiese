package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Notice;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.myEnum.NoticeTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAdminNoticeService extends IService<Admin> {
    /**
     * 查询通知
     */
    List<Notice> selectNotice(Integer id, FlagEnum flagEnum);

    List<Notice> selectNotice(NoticeTypeEnum noticeTypeEnum, String name, Integer Day);
    /**
     * 发布通知
     */
    Boolean insertNotice(Notice notice);
    /**
     * 修改通知状态
     */
    Boolean updateNoticeState(Integer id, FlagEnum flagEnum);
    /**
     * 修改通知
     */
    Boolean updateNotice(Notice notice);
}
