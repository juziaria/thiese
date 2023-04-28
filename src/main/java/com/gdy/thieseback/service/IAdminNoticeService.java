package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Notice;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.myEnum.NoticeTypeEnum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Mapper
@Service
public interface IAdminNoticeService extends IService<Admin> {
    /**
     * 查询通知
     */
    List<Notice> selectNotice(Integer id, FlagEnum flagEnum);

    List<Notice> selectNotice(NoticeTypeEnum noticeTypeEnum, String name, Integer Day, FlagEnum flagEnum);
    /**
     * 发布通知
     */
    Integer insertNotice(Notice notice);
    /**
     * 修改通知状态
     */
    Boolean updateNoticeState(Integer id, FlagEnum flagEnum);
    /**
     * 修改通知
     */
    Boolean updateNotice(Notice notice);
}
