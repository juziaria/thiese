package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Admin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAdminQuestionnaireService extends IService<Admin> {
    /**
     *展示收到的问卷建议
     */
    List<String> showAdvices(Integer grade);
    /**
     *是否打开问卷填写
     */
    Boolean updateIfOpenQuestionnaire(Boolean value);
}
