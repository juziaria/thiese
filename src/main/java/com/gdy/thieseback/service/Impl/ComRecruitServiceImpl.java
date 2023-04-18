package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.mapper.ComRecruitMapper;
import com.gdy.thieseback.service.IComRecruitService;
import org.springframework.stereotype.Service;


@Service
public class ComRecruitServiceImpl extends ServiceImpl<ComRecruitMapper,Recruit> implements IComRecruitService {

    @Override
    public Recruit publish(Recruit recruit){
        baseMapper.insert(recruit);
        return baseMapper.selectById(recruit.getId());
    }

}
