package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Mapper
@Service
public interface IAdminQuestionnaireService extends IService<Admin> {
    /**
     *展示收到的问卷建议
     */
    List<String> showAdvices(Integer grade, String major);
    /**
     *是否打开问卷填写
     */
    Boolean updateIfOpenQuestionnaire(Boolean value);
}
