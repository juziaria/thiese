package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.mapper.EmployPositionMapper;
import com.gdy.thieseback.entity.EmployPosition;
import com.gdy.thieseback.req.EmployPositionReq;
import com.gdy.thieseback.resp.PageResp;
import com.gdy.thieseback.service.EmployPositionService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployPositionServiceImpl extends ServiceImpl<EmployPositionMapper, EmployPosition> implements EmployPositionService {
    @Resource
    private EmployPositionMapper employPositionMapper;

    @Override
    public PageResp<EmployPosition> getList(EmployPositionReq employPositionReq){

        QueryWrapper<EmployPosition> queryWrapper = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(employPositionReq.getAvailbletime())){
            queryWrapper.lambda().eq(EmployPosition::getAvailbletime,employPositionReq.getAvailbletime());
        }

        if(!ObjectUtils.isEmpty(employPositionReq.getJobname())){
            queryWrapper.lambda().eq(EmployPosition::getJobname,employPositionReq.getJobname());
        }

        if(!ObjectUtils.isEmpty(employPositionReq.getComname())){
            queryWrapper.lambda().eq(EmployPosition::getComname,employPositionReq.getComname());
        }

        if(!ObjectUtils.isEmpty(employPositionReq.getWorkplace())){
            queryWrapper.lambda().eq(EmployPosition::getWorkplace,employPositionReq.getWorkplace());
        }

        if(!ObjectUtils.isEmpty(employPositionReq.getMajor())){
            queryWrapper.lambda().eq(EmployPosition::getMajor,employPositionReq.getMajor());
        }

        if(!ObjectUtils.isEmpty(employPositionReq.getFlag())){
            queryWrapper.lambda().eq(EmployPosition::getFlag,employPositionReq.getFlag());
        }

        if(!ObjectUtils.isEmpty(employPositionReq.getDegree())){
            queryWrapper.lambda().eq(EmployPosition::getDegree,employPositionReq.getDegree());
        }
        Page<EmployPosition> page = new Page<>(employPositionReq.getPage(),employPositionReq.getSize());
        IPage<EmployPosition> employPositonIPage = employPositionMapper.selectPage(page,queryWrapper);
        PageResp<EmployPosition> pageResp = new PageResp<>();
        pageResp.setTotal(employPositonIPage.getTotal());
        pageResp.setList(employPositonIPage.getRecords());
        return  pageResp;
    }


}
