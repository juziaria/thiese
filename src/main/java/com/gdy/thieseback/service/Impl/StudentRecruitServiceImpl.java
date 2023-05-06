package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.mapper.StuRecruitMapper;
import com.gdy.thieseback.service.StudentRecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentRecruitServiceImpl extends ServiceImpl<StuRecruitMapper, Recruit> implements StudentRecruitService {

    @Resource
    private StuRecruitMapper stuRecruitMapper;

    @Override
    public Recruit recruitmentShow(Recruit recruit){

        return stuRecruitMapper.selectById(recruit.getId());
    }
}
