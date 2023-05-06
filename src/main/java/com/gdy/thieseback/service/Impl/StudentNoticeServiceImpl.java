package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Notice;
import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.mapper.StuRecruitMapper;
import com.gdy.thieseback.mapper.StudentNoticeMapper;
import com.gdy.thieseback.myEnum.NoticeTypeEnum;
import com.gdy.thieseback.req.NoticeReq;
import com.gdy.thieseback.service.StudentNoticeService;
import com.gdy.thieseback.service.StudentRecruitService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentNoticeServiceImpl extends ServiceImpl<StudentNoticeMapper, Notice> implements StudentNoticeService {



    @Override
    public Page<Notice> queryPage(NoticeReq noticeReq) {
        Page<Notice> page = new Page<>(noticeReq.getPageNum(), noticeReq.getPageSize());
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        if (ObjectUtils.isNotEmpty(noticeReq)) {
            if (ObjectUtils.isNotEmpty(noticeReq.getTitle())) {
                queryWrapper.lambda().eq(Notice::getTitle, noticeReq.getTitle());

            }

        }
        queryWrapper.lambda().ne(Notice::getType, NoticeTypeEnum.TripartiteAgreement.getCode()).
                orderByDesc(Notice::getPublishTime);
        return this.page(page, queryWrapper);
    }
}
