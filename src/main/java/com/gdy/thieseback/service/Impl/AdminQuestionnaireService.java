package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.service.IAdminQuestionnaireService;
import com.gdy.thieseback.util.Conversation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdminQuestionnaireService extends ServiceImpl<AdminMapper, Admin> implements IAdminQuestionnaireService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();

    @Override
    public List<String> showAdvices(Integer grade) {
        return adminMapper.selectAdvices(grade);
    }

    @Override
    public Boolean updateIfOpenQuestionnaire(Boolean value) {
        return adminMapper.updateIfOpenQuestionnaire(value);
    }

}
