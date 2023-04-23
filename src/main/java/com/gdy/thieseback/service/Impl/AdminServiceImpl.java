package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.*;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.service.AdminService;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 管理员业务层
 */
@Service
@Transactional
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    private final Conversation conversation = new Conversation();

    @Override
    public Boolean uploadDocument(Document document) {
        return adminMapper.insertDocument(document);
    }

    @Override
    public Boolean downloadDocument(String saveDirPath, Integer id) {
        Document document = adminMapper.selectDocument(id, FlagEnum.Upload.getCode()).get(0);
        String savePath = document.getSavaPath(saveDirPath);
        try {
            document.save(savePath);
        }catch (Exception EX){
            return false;
        }

        return true;
    }

    @Override
    public Boolean deleteDocument(Integer id) {
        return adminMapper.deleteDocument(id, FlagEnum.Delete.getCode());
    }

    @Override
    public List<DocumentInfo> showDocuments() {
        List<Document> documents =  adminMapper.selectDocument(null, FlagEnum.Upload.getCode());
        List<DocumentInfo> documentInfoList = new ArrayList<>();

        for(Document document : documents){
            DocumentInfo documentInfo = conversation.DocumentToDocumentInfo(document);
            documentInfoList.add(documentInfo);
        }

        return documentInfoList;
    }

    @Override
    public Document selectDocument(Integer id) {
        return adminMapper.selectDocument(id, 0).get(0);
    }

    @Override
    public Integer selectDocumentCount() {
        return adminMapper.selectDocumentCount(FlagEnum.Upload.getCode());
    }

    @Override
    public List<Notice> selectNotice(Integer id, FlagEnum flagEnum) {
        if (flagEnum == null){
            return adminMapper.selectNotices(id, null);
        }
        else {
            return adminMapper.selectNotices(id, flagEnum.getCode());
        }
    }

    @Override
    public Boolean insertNotice(Notice notice) {
        return adminMapper.insertNotice(notice);
    }

    @Override
    public Boolean updateNoticeState(Integer id, FlagEnum flagEnum) {
        return adminMapper.updateNoticeFlag(id, flagEnum.getCode());
    }

    @Override
    public Boolean updateNotice(Notice notice) {
        return adminMapper.updateNotice(notice);
    }

    @Override
    public HashMap<String, String> selectCompanyName() {
        List<Company> companyList = adminMapper.selectCompany(null, null, null, null,
                FlagEnum.Upload.getCode());

        HashMap<String, String> companyInfo = new HashMap<>();
        for (Company company : companyList) {
            companyInfo.put(company.getScc(), company.getName());
        }

        return companyInfo;
    }

    @Override
    public List<Recruit> recruitmentShow(FlagEnum flagEnum, String companyScc, String major) {
        return adminMapper.selectRecruitments(null, flagEnum.getCode(), companyScc, major);
    }

    @Override
    public Boolean updateRecruitmentFlag(Integer id, FlagEnum flagEnum) {
        return adminMapper.updateRecruitmentFlag(id, flagEnum.getCode());
    }

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

    @Override
    public List<MeetingInfo> showMeeting(FlagEnum flagEnum) {
        List<Meeting> meetingList = adminMapper.selectMeeting(flagEnum.getCode(), null);
        List<MeetingInfo> meetingInfoList = new ArrayList<>();

        for(Meeting meeting : meetingList){
            Company company = adminMapper.selectCompany(meeting.getCompanyScc(),
                    null, null, null, FlagEnum.Upload.getCode()).get(0);

            MeetingLocation meetingLocation = adminMapper.selectMeetingLocation(
                    meeting.getMeetingLocationId());

            MeetingInfo meetingInfo = conversation.MeetingToMeetingInfo(meeting,
                    company.getName(), meetingLocation);

            meetingInfoList.add(meetingInfo);
        }

        return meetingInfoList;
    }

    @Override
    public void deleteMeeting(Integer id) {
        val meeting = adminMapper.selectMeeting(null, id).get(0);
        adminMapper.updateMeetingLocation(FlagEnum.NotUsed.getCode(), meeting.getMeetingLocationId());
        adminMapper.updateMeetingFlag(id, FlagEnum.Delete.getCode());
    }

    @Override
    public Boolean EnsureMeeting(Integer id, Integer classroomId) {
        adminMapper.updateMeetingLocationFlag(classroomId, FlagEnum.Using.getCode());
        adminMapper.updateMeetingLocation(id, classroomId);
        return adminMapper.updateMeetingFlag(id, FlagEnum.NotStarted.getCode());
    }

    @Override
    public HashMap<Integer, String> showEmptyClassroom() {
        List<MeetingLocation> meetingLocationList = adminMapper.selectEmptyMeetingLocation(
                FlagEnum.NotUsed.getCode(), null);

        HashMap<Integer, String> emptyClassrooom = new HashMap<>();
        for(val classroom : meetingLocationList){
            emptyClassrooom.put(classroom.getId(), classroom.getName());
        }
        return emptyClassrooom;
    }

    @Override
    public List<String> showAdvices(Integer grade) {
        return adminMapper.selectAdvices(grade);
    }

    @Override
    public Boolean updateIfOpenQuestionnaire(Boolean value) {
        return adminMapper.updateIfOpenQuestionnaire(value);
    }


}
