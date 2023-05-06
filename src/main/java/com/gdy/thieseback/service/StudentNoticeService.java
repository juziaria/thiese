package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Notice;
import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.req.NoticeReq;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentNoticeService extends IService<Notice> {

   Page<Notice> queryPage(NoticeReq noticeReq);

}
