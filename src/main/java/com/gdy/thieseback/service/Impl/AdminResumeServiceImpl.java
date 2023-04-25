package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.dto.ResumeInfo;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Document;
import com.gdy.thieseback.entity.Resume;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminRecruitService;
import com.gdy.thieseback.service.IAdminResumeService;
import com.gdy.thieseback.util.Conversation;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AdminResumeServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminResumeService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();


    @Override
    public List<ResumeInfo> showResumes() {
        List<Resume> resumeList = adminMapper.selectResumes(FlagEnum.Upload.getCode(),null);

        List<ResumeInfo> resumeInfoList = new ArrayList<>();
        for (Resume resume : resumeList ) {
            ResumeInfo resumeInfo = conversation.ResumeToResumeInfo(resume);
            resumeInfoList.add(resumeInfo);
        }

        return resumeInfoList;
    }

    @Override
    public Boolean deleteResume(Integer id) {
        return adminMapper.deleteResume(id, FlagEnum.Delete.getCode());
    }

    @Override
    public Boolean downLoadResume(Integer id, String dirPath) {
        Resume resume = adminMapper.selectResumes(FlagEnum.Upload.getCode(), id).get(0);
        Document document = conversation.ResumeToDocument(resume);

        String savePath = document.getSavaPath(dirPath);
        return document.save(savePath);
    }

    @Override
    public Boolean upLoadResume(Resume resume) {
        return adminMapper.insertResume(resume);
    }
}
