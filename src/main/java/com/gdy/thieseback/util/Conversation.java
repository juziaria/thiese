package com.gdy.thieseback.util;

import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Conversation {
    public Student StuInfoToStu(StuInfo stuInfo){
        Student student = new Student();
        return StuInfoToStu(stuInfo, student);
    }

    @Autowired
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

    @Autowired
    public Company CompanyInfoToCompany(CompanyInfo companyInfo, Company company){
        company.setScc(companyInfo.getId());
        company.setName(companyInfo.getName());
        company.setPhone(companyInfo.getPhone());
        company.setEmail(companyInfo.getEmail());
        company.setAddress(companyInfo.getAddress());

        Date createTime = this.StringToDate(companyInfo.getCreateTime());
        company.setCreateTime(createTime);

        company.setPrincipal(companyInfo.getPrincipal());

        return company;
    }

    public CompanyInfo CompanyToCompanyInfo(Company company){
        CompanyInfo companyInfo = new CompanyInfo();

        companyInfo.setId(company.getScc());
        companyInfo.setName(company.getName());
        companyInfo.setPhone(company.getPhone());
        companyInfo.setEmail(company.getEmail());
        companyInfo.setAddress(company.getAddress());

        String transformDate = this.DateToString(company.getCreateTime());
        companyInfo.setCreateTime(transformDate);

        companyInfo.setPrincipal(company.getPrincipal());

        return companyInfo;
    }

    public DocumentInfo DocumentToDocumentInfo(Document document){
        DocumentInfo documentInfo = new DocumentInfo();

        documentInfo.setId(document.getId());
        documentInfo.setSize(this.setSize(document.getSize()));
        documentInfo.setFileName(documentInfo.getFileName());

        String transformDate = this.DateToString(document.getUploadTime());
        documentInfo.setUploadTime(transformDate);

        return documentInfo;
    }

    private String setSize(long size) {
        int GB = 1024 * 1024 * 1024;//定义GB的计算常量
        int MB = 1024 * 1024;//定义MB的计算常量
        int KB = 1024;//定义KB的计算常量
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String resultSize = "";
        if (size / GB >= 1) {
            //如果当前Byte的值大于等于1GB
            resultSize = df.format(size / (float) GB) + "GB   ";
        } else if (size / MB >= 1) {
            //如果当前Byte的值大于等于1MB
            resultSize = df.format(size / (float) MB) + "MB   ";
        } else if (size / KB >= 1) {
            //如果当前Byte的值大于等于1KB
            resultSize = df.format(size / (float) KB) + "KB   ";
        } else {
            resultSize = size + "B   ";
        }

        return resultSize;
    }

    public Date StringToDate(String dateStr){
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Parameter.DatePattern);
        try {
            if(dateStr != null && !dateStr.equals("")) {
                date =  simpleDateFormat.parse(dateStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public String DateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Parameter.DatePattern);
        return simpleDateFormat.format(date);
    }

    public NoticeInfo NoticeToNoticeInfo(Notice notice, List<Document> documents){
        NoticeInfo noticeInfo = new NoticeInfo();

        NoticeTypeEnum noticeType = NoticeTypeEnum.find(notice.getType());
        noticeInfo.setType(noticeType.getContent());

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
            String publishTime = this.DateToString(notice.getPublishTime());
            noticeInfo.setPublishTime(publishTime);
        }

        return noticeInfo;
    }

    public Notice NoticeInfoToNotice(NoticeInfo noticeInfo){
        Notice notice = new Notice();

        NoticeTypeEnum noticeType = NoticeTypeEnum.find(noticeInfo.getType());
        notice.setType(noticeType.getCode());

        notice.setId(noticeInfo.getId());
        notice.setCollage(noticeInfo.getCollage());
        notice.setTitle(noticeInfo.getTitle());
        notice.setContent(noticeInfo.getContent());

        val documentIdList = noticeInfo.getDocument().keySet().toArray(new String[0]);
        String documentIdStr = String.join(Parameter.splitChar, documentIdList);
        notice.setDocumentId(documentIdStr);

        Date publishTime = this.StringToDate(noticeInfo.getPublishTime());
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

    public MeetingInfo MeetingToMeetingInfo(Meeting meeting,
                                            String companyName,
                                            MeetingLocation meetingLocation){
        MeetingInfo meetingInfo = new MeetingInfo();

        meetingInfo.setId(meeting.getId());
        meetingInfo.setName(meeting.getName());

        HashMap<String, String> company = new HashMap<>();
        company.put(meeting.getCompanyScc(), companyName);
        meetingInfo.setCompany(company);

        MeetingFormatEnum meetingFormat = MeetingFormatEnum.find(meetingLocation.getFormat());
        if(meetingFormat != null){
            meetingInfo.setMeetingFormat(meetingFormat.getContent());
        }

        HashMap<Integer, String> classroom = new HashMap<>();
        classroom.put(meetingLocation.getId(), meetingLocation.getName());
        meetingInfo.setLocation(classroom);

        meetingInfo.setAmount(meetingLocation.getMaxCount());
        meetingInfo.setMajor(meeting.getMajor());

        MeetingTypeEnum meetingType = MeetingTypeEnum.find(meeting.getType());
        if(meetingType != null){
            meetingInfo.setMeetingType(meetingType.getContent());
        }

        meetingInfo.setStartTime(this.DateToString(meeting.getStartTime()));

        return meetingInfo;
    }

    public Meeting MeetingInfoToMeeting(MeetingInfo meetingInfo){
        Meeting meeting = new Meeting();

        meeting.setId(meetingInfo.getId());
        meeting.setName(meetingInfo.getName());

        String[] keys = meetingInfo.getCompany().keySet().toArray(new String[0]);
        if(keys.length > 0){
            meeting.setCompanyScc(keys[0]);
        }

        Integer[] classroomIdList = meetingInfo.getLocation().keySet().toArray(new Integer[0]);
        meeting.setMeetingLocationId(classroomIdList[0]);

        meeting.setMajor(meetingInfo.getMajor());

        MeetingTypeEnum meetingType = MeetingTypeEnum.find(meetingInfo.getMeetingType());
        if(meetingType != null){
            meeting.setType(meetingType.getCode());
        }

        meeting.setStartTime(this.StringToDate(meetingInfo.getStartTime()));

        return meeting;
    }
}
