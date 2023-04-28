package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Recruit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

//@Mapper
@Service
public interface IComRecruitService extends IService<Recruit> {

     Recruit publish(Recruit recruit);

}
