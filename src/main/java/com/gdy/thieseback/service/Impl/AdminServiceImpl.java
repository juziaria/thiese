package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.*;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.service.AdminService;
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

    /**
     * 定义一个md5算法的加密处理
     */
    private  String getMD5(String PWD,String salt){
        for(int i = 0; i<3;i++){
            PWD= DigestUtils.md5DigestAsHex((salt+PWD+salt).getBytes()).toUpperCase();
        }
        return PWD;
    }


    @Override
    public Admin login(String id,String pwd) {
        int flag = FlagEnum.Upload.getCode();

        //密码加密

        return adminMapper.findAdmin(id, pwd, flag).get(0);
    }

    @Override
    public List<String> selectStuCollage() {
        return adminMapper.selectStuCollage(FlagEnum.Upload.getCode());
    }

    @Override
    public List<Integer> selectStuGrade() {
        return adminMapper.selectStuGrade(FlagEnum.Upload.getCode());
    }

    @Override
    public List<String> selectStuMajor() {
        return adminMapper.selectStuMajor(FlagEnum.Upload.getCode());
    }

    @Override
    public List<Integer> selectStuClass() {
        return adminMapper.selectStuClass(FlagEnum.Upload.getCode());
    }

    @Override
    public List<String> selectCompanyAddress() {
        return adminMapper.selectCompanyAddress(FlagEnum.Upload.getCode());
    }

    @Override
    public String deleteStudents(String[] idArray) {
        for (String id : idArray) {
            if(!adminMapper.deleteStu(id, FlagEnum.Delete.getCode())) {
                return String.format("The Student {0} deleted failed!", id);
            }
        }
        return "success";
    }

    @Override
    public String deleteCompany(String[] idArray) {
        for (String id : idArray) {
            if(!adminMapper.deleteCompany(id, FlagEnum.Delete.getCode())){
                return String.format("The Company {0} deleted failed!", id);
            }
        }
        return "success";
    }

    @Override
    public List<StuInfo> SelectStu(Integer grade, String collage, String major, Integer stuClass) {
        List<Student> students = adminMapper.selectStu(grade, collage, major, stuClass, FlagEnum.Upload.getCode());

        List<StuInfo> stuInfos = new ArrayList<>();

        for (Student student : students) {
            stuInfos.add(conversation.StuToStuInfo(student));
        }
        return stuInfos;
    }

    @Override
    public List<CompanyInfo> SelectCompany(Date start, Date end, String address) {
        List<Company> companies = adminMapper.selectCompany(null, start, end, address, FlagEnum.Upload.getCode());
        List<CompanyInfo> companyInfos = new ArrayList<>();

        for (Company company: companies ) {
            companyInfos.add(conversation.CompanyToCompanyInfo(company));
        }

        return companyInfos;
    }

    @Override
    public Boolean initialStuPassword(String id) {
        return adminMapper.initialStuPassword(id, Parameter.InitPwd);
    }

    @Override
    public Boolean initialCompanyPassword(String id) {
        return adminMapper.initialCompanyPassword(id, Parameter.InitPwd);
    }

    @Override
    public Boolean updateStu(StuInfo stuInfo) {
        Student student = conversation.StuInfoToStu(stuInfo);
        return adminMapper.updateStu(student);
    }

    @Override
    public Boolean updateCompany(CompanyInfo companyInfo) {
        Company company = conversation.CompanyInfoToCompany(companyInfo);
        return adminMapper.updateCompany(company);
    }

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
            companyInfo.put(company.getId(), company.getName());
        }

        return companyInfo;
    }

    @Override
    public List<String> selectWorkPlace() {
        return adminMapper.selectWorkPlace();
    }

    @Override
    public Boolean publishRecruitment(Recruitment recruitment, Requirement requirement) {
        Boolean result = false;

        result = adminMapper.insertRequirement(requirement);

        recruitment.setRequirementId(requirement.getId());
        recruitment.setFlag(FlagEnum.Publish.getCode());
        result = adminMapper.insertRecruitment(recruitment);

        return result;
    }

    @Override
    public List<RecruitInfo> recruitmentShow(FlagEnum flagEnum, Integer salaryMin, Integer salaryMax, String workPlace) {
        List<RecruitInfo> recruitInfoList = new ArrayList<>();
        List<Recruitment> recruitmentList = adminMapper.selectRecruitments(flagEnum.getCode(),
                salaryMin, salaryMax, workPlace);

        for(Recruitment recruitment : recruitmentList){
            Requirement requirement = adminMapper.selectRequirement(recruitment.getId());
            Company company = adminMapper.selectCompany(recruitment.getCompanyId(),
                    null, null, null, FlagEnum.Upload.getCode()).get(0);

            recruitInfoList.add(conversation.toRecruitInfo(recruitment, requirement, company));
        }

        return recruitInfoList;
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
        return null;
    }

    @Override
    public Boolean deleteMeeting() {
        return null;
    }

    @Override
    public Boolean EnsureMeeting(Integer id, Integer classroomId) {
        return null;
    }

    @Override
    public HashMap<Integer, String> showEmptyClassroom() {
        return null;
    }


}
