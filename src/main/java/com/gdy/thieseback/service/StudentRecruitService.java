package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Recruit;
import org.springframework.stereotype.Service;

@Service
public interface StudentRecruitService extends IService<Recruit> {
    /**
     *展示详情招聘信息
     */
    Recruit recruitmentShow(Recruit recruit);

}
