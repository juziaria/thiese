package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.mapper.EmployDoubleMeetingMapper;
import com.gdy.thieseback.entity.EmployDoubleMeeting;
import com.gdy.thieseback.req.EmployDoubleMeetingReq;
import com.gdy.thieseback.req.EmployPositionReq;
import com.gdy.thieseback.resp.PageResp;
import com.gdy.thieseback.service.EmployDoubleMeetingService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class EmployDoubleMeetingServiceImpl extends ServiceImpl<EmployDoubleMeetingMapper, EmployDoubleMeeting> implements EmployDoubleMeetingService {
    @Resource
    private EmployDoubleMeetingMapper employDoubleMeetingMapper;

    @Override
    public PageResp<EmployDoubleMeeting> getList(EmployDoubleMeetingReq employDoubleMeetingReq){

        QueryWrapper<EmployDoubleMeeting> queryWrapper = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(employDoubleMeetingReq.getMeetingtime())){
            queryWrapper.lambda().eq(EmployDoubleMeeting::getMeetingtime,employDoubleMeetingReq.getMeetingtime());
        }

        if(!ObjectUtils.isEmpty(employDoubleMeetingReq.getInterviewtime())){
            queryWrapper.lambda().eq(EmployDoubleMeeting::getInterviewtime,employDoubleMeetingReq.getInterviewtime());
        }

        if(!ObjectUtils.isEmpty(employDoubleMeetingReq.getName())){
            queryWrapper.lambda().eq(EmployDoubleMeeting::getName,employDoubleMeetingReq.getName());
        }

        if(!ObjectUtils.isEmpty(employDoubleMeetingReq.getPlace())){
            queryWrapper.lambda().eq(EmployDoubleMeeting::getPlace,employDoubleMeetingReq.getPlace());
        }

        if(!ObjectUtils.isEmpty(employDoubleMeetingReq.getMajor())){
            queryWrapper.lambda().eq(EmployDoubleMeeting::getMajor,employDoubleMeetingReq.getMajor());
        }


        Page<EmployDoubleMeeting> page = new Page<>(employDoubleMeetingReq.getPage(),employDoubleMeetingReq.getSize());
        IPage<EmployDoubleMeeting> employPositonIPage = employDoubleMeetingMapper.selectPage(page,queryWrapper);
        PageResp<EmployDoubleMeeting> pageResp = new PageResp<>();
        pageResp.setTotal(employPositonIPage.getTotal());
        pageResp.setList(employPositonIPage.getRecords());
        return  pageResp;
    }


}
