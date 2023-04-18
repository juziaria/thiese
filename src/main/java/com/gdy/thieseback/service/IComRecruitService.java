package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Recruit;

public interface IComRecruitService extends IService<Recruit> {

     Recruit publish(Recruit recruit);

}
