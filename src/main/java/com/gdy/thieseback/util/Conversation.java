package com.gdy.thieseback.util;

import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class Conversation {

    public Student StuInfoToStu(StuInfo stuInfo){
        Student student = new Student();
        return StuInfoToStu(stuInfo, student);
    }

    public Student StuInfoToStu(StuInfo stuInfo, Student student){
        student.setId(stuInfo.getId());
        student.setIdentity(stuInfo.getStudentIdentity());
        student.setName(stuInfo.getStudentName());
        student.setCollage(stuInfo.getCollage());
        student.setGrade(stuInfo.getGrade());
        student.setStudentClass(stuInfo.getStudentClass());
        student.setMajor(stuInfo.getMajor());
        student.setPhone(stuInfo.getStudentPhone());
        student.setEmail(stuInfo.getStudentEmail());

        GenderEnum genderEnum = GenderEnum.find(stuInfo.getStudentGender());
        if(genderEnum != null){
            Integer gender = genderEnum.getCode();
            student.setGender(gender);
        }

        return student;
    }

    public StuInfo StuToStuInfo(Student student, EmploymentStatusEnum employmentStatusEnum){
        StuInfo stuInfo = new StuInfo();

        stuInfo.setId(student.getId());
        stuInfo.setStudentIdentity(student.getIdentity());
        stuInfo.setStudentName(student.getName());
        stuInfo.setCollage(student.getCollage());
        stuInfo.setGrade(student.getGrade());
        stuInfo.setStudentClass(student.getStudentClass());
        stuInfo.setMajor(student.getMajor());
        stuInfo.setStudentPhone(student.getPhone());
        stuInfo.setStudentEmail(student.getEmail());

        GenderEnum genderEnum = GenderEnum.find(student.getGender());
        stuInfo.setStudentGender(genderEnum.getContent());

        stuInfo.setEmployment(employmentStatusEnum.getContent());

        return stuInfo;
    }

    public Company CompanyInfoToCompany(CompanyInfo companyInfo){
        Company company = new Company();
        return CompanyInfoToCompany(companyInfo, company);
    }

    public Company CompanyInfoToCompany(CompanyInfo companyInfo, Company company){
        company.setScc(companyInfo.getScc());
        company.setName(companyInfo.getName());
        company.setPhone(companyInfo.getPhone());
        company.setEmail(companyInfo.getEmail());
        company.setAddress(companyInfo.getAddress());

        company.setPrincipal(companyInfo.getPrincipal());

        return company;
    }

    public CompanyInfo CompanyToCompanyInfo(Company company){
        CompanyInfo companyInfo = new CompanyInfo();

        companyInfo.setScc(company.getScc());
        companyInfo.setName(company.getName());
        companyInfo.setPhone(company.getPhone());
        companyInfo.setEmail(company.getEmail());
        companyInfo.setAddress(company.getAddress());

        companyInfo.setPrincipal(company.getPrincipal());

        return companyInfo;
    }

    public DocumentInfo DocumentToDocumentInfo(Document document){
        DocumentInfo documentInfo = new DocumentInfo();

        documentInfo.setId(document.getId());
        documentInfo.setSize(AdminToolHelper.setSize(document.getSize()));
        documentInfo.setFileName(documentInfo.getFileName());

        String transformDate = AdminToolHelper.DateToString(document.getUploadTime());
        documentInfo.setUploadTime(transformDate);

        return documentInfo;
    }

    public NoticeInfo NoticeToNoticeInfo(Notice notice, List<Document> documents){
        NoticeInfo noticeInfo = new NoticeInfo();

        noticeInfo.setId(notice.getId());
        noticeInfo.setCollage(notice.getCollage());
        noticeInfo.setTitle(notice.getTitle());
        noticeInfo.setContent(notice.getContent());

        HashMap<Integer, String> documentMap = new HashMap<>();
        for(Document document : documents){
            documentMap.put(document.getId(), document.getFileName());
        }
        noticeInfo.setDocument(documentMap);

        if(notice.getPublishTime() != null){
            String publishTime = AdminToolHelper.DateToString(notice.getPublishTime());
            noticeInfo.setPublishTime(publishTime);
        }

        return noticeInfo;
    }

    public Notice NoticeInfoToNotice(NoticeInfo noticeInfo){
        Notice notice = new Notice();

        notice.setId(noticeInfo.getId());
        notice.setCollage(noticeInfo.getCollage());
        notice.setTitle(noticeInfo.getTitle());
        notice.setContent(noticeInfo.getContent());

        val documentIdList = noticeInfo.getDocument().keySet().toArray(new String[0]);
        String documentIdStr = String.join(Parameter.splitChar, documentIdList);
        notice.setDocumentId(documentIdStr);

        Date publishTime = AdminToolHelper.StringToDate(noticeInfo.getPublishTime());
        notice.setPublishTime(publishTime);

        return notice;
    }

    public ResumeInfo ResumeToResumeInfo(Resume resume){
        ResumeInfo resumeInfo = new ResumeInfo();

        resumeInfo.setId(resume.getId());

        String name = String.format("%s.%s",resume.getFileName(),resume.getExtension());
        resumeInfo.setFileFullName(name);

        return resumeInfo;
    }

    public Document ResumeToDocument(Resume resume){
        return new Document(resume.getContent(),
                resume.getFileName(), resume.getExtension());
    }

    public Resume DocumentToResume(Document document, FlagEnum flagEnum){
        Resume resume = new Resume();

        resume.setContent(document.getContent());
        resume.setFileName(document.getFileName());
        resume.setExtension(document.getExtension());
        resume.setFlag(flagEnum.getCode());

        return resume;
    }

    public MeetingInfo MeetingToMeetingInfo(EmployMeeting employMeeting){
        MeetingInfo meetingInfo = new MeetingInfo();

        meetingInfo.setId(employMeeting.getId());
        meetingInfo.setTime(AdminToolHelper.DateToString(employMeeting.getTime()));
        meetingInfo.setName(employMeeting.getName());
        meetingInfo.setMaster(employMeeting.getMaster());
        meetingInfo.setPlace(employMeeting.getPlace());
        meetingInfo.setAmount(employMeeting.getAmount());
        meetingInfo.setMajor(employMeeting.getMajor());

        MeetingTypeEnum meetingTypeEnum = MeetingTypeEnum.find(employMeeting.getType());
        meetingInfo.setType(meetingTypeEnum.getContent());

        return meetingInfo;
    }

    public EmployMeeting MeetingInfoToMeeting(MeetingInfo meetingInfo){
        EmployMeeting employMeeting = new EmployMeeting();

        employMeeting.setId(meetingInfo.getId());
        employMeeting.setTime(AdminToolHelper.StringToDate(meetingInfo.getTime()));
        employMeeting.setName(meetingInfo.getName());
        employMeeting.setMaster(meetingInfo.getMaster());
        employMeeting.setPlace(meetingInfo.getPlace());
        employMeeting.setAmount(meetingInfo.getAmount());
        employMeeting.setMajor(meetingInfo.getMajor());

        MeetingTypeEnum meetingTypeEnum = MeetingTypeEnum.find(meetingInfo.getType());
        employMeeting.setType(meetingTypeEnum.getCode());

        return employMeeting;
    }

}
