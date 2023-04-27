package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.service.IAdminDataAnalysisService;
import com.gdy.thieseback.util.Conversation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AdminDataAnalysisService extends ServiceImpl<AdminMapper, Admin> implements IAdminDataAnalysisService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();




}
