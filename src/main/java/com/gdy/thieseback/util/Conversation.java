package com.gdy.thieseback.util;

import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.EmploymentStatusEnum;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.myEnum.GenderEnum;
import com.gdy.thieseback.myEnum.NoticeTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Conversation {
    @Autowired
    public Student StuInfoToStu(StuInfoDto stuInfoDto){
        Student student = new Student();
        return StuInfoToStu(stuInfoDto, student);
    }

    @Autowired
    public Student StuInfoToStu(StuInfoDto stuInfoDto, Student student){
        student.setId(stuInfoDto.getId());
        student.setStudentIdentity(stuInfoDto.getStudentIdentity());
        student.setStudentName(stuInfoDto.getStudentName());
        student.setCollege(stuInfoDto.getCollege());
        student.setGrade(stuInfoDto.getGrade());
        student.setStudentClass(stuInfoDto.getStudentClass());
        student.setMajor(stuInfoDto.getMajor());
        student.setStudentPhone(stuInfoDto.getStudentPhone());
        student.setStudentEmail(stuInfoDto.getStudentEmail());

        GenderEnum genderEnum = GenderEnum.find(stuInfoDto.getStudentGender());
        if(genderEnum != null){
           // Integer gender = genderEnum.getCode();
            student.setStudentGender(Integer.toString(genderEnum.getCode()));
        }

        EmploymentStatusEnum employmentStatusEnum = EmploymentStatusEnum.find(stuInfoDto.getEmploymentStatus());
        if(employmentStatusEnum != null){
            Integer employmentId = employmentStatusEnum.getCode();
            student.setEmploymentStatus(employmentId);
        }

        return student;
    }

    @Autowired
    public StuInfoDto StuToStuInfo(Student student){
        StuInfoDto stuInfoDto = new StuInfoDto();

        stuInfoDto.setId(student.getId());
        stuInfoDto.setStudentIdentity(student.getStudentIdentity());
        stuInfoDto.setStudentName(student.getStudentName());
        stuInfoDto.setCollege(student.getCollege());
        stuInfoDto.setGrade(student.getGrade());
        stuInfoDto.setStudentClass(student.getStudentClass());
        stuInfoDto.setMajor(student.getMajor());
        stuInfoDto.setStudentPhone(student.getStudentPhone());
        stuInfoDto.setStudentEmail(student.getStudentEmail());

        GenderEnum genderEnum = GenderEnum.find(student.getStudentGender());
        stuInfoDto.setStudentGender(genderEnum.getContent());

        EmploymentStatusEnum employmentStatusEnum = EmploymentStatusEnum.find(student.getEmploymentStatus());
        stuInfoDto.setEmploymentStatus(Integer.valueOf(employmentStatusEnum.getContent()));

        return stuInfoDto;
    }

    public Company CompanyInfoToCompany(CompanyInfoDto companyInfoDto){
        Company company = new Company();
        return CompanyInfoToCompany(companyInfoDto, company);
    }

    @Autowired
    public Company CompanyInfoToCompany(CompanyInfoDto companyInfoDto, Company company){
        company.setScc(companyInfoDto.getId());
        company.setCompanyName(companyInfoDto.getName());
        company.setCompanyPhone(companyInfoDto.getPhone());
        company.setCompanyEmail(companyInfoDto.getEmail());
        company.setAddress(companyInfoDto.getAddress());

        Date createTime = this.StringToDate(companyInfoDto.getCreateTime());
        company.setCreateTime(createTime);

        company.setPrincipal(companyInfoDto.getCurator());

        return company;
    }

    @Autowired
    public CompanyInfoDto CompanyToCompanyInfo(Company company){
        CompanyInfoDto companyInfoDto = new CompanyInfoDto();

        companyInfoDto.setId(company.getScc());
        companyInfoDto.setName(company.getCompanyName());
        companyInfoDto.setPhone(company.getCompanyPhone());
        companyInfoDto.setEmail(company.getCompanyEmail());
        companyInfoDto.setAddress(company.getAddress());

        String transformDate = this.DateToString(company.getCreateTime());
        companyInfoDto.setCreateTime(transformDate);

        companyInfoDto.setCurator(company.getPrincipal());

        return companyInfoDto;
    }

    @Autowired
    public DocumentInfo DocumentToDocumentInfo(Document document){
        DocumentInfo documentInfoDto = new DocumentInfo();

        documentInfoDto.setId(document.getId());
        documentInfoDto.setSize(this.setSize(document.getSize()));
        documentInfoDto.setFileName(documentInfoDto.getFileName());

        String transformDate = this.DateToString(document.getUploadTime());
        documentInfoDto.setUploadTime(transformDate);

        return documentInfoDto;
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

    @Autowired
    public NoticeInfo NoticeToNoticeInfo(Notice notice, List<Document> documents){
        NoticeInfo noticeInfoDto = new NoticeInfo();

        NoticeTypeEnum noticeType = NoticeTypeEnum.find(notice.getType());
        noticeInfoDto.setType(Integer.valueOf(noticeType.getContent()));

        noticeInfoDto.setId(notice.getId());
        noticeInfoDto.setCollage(notice.getCollage());
        noticeInfoDto.setTitle(notice.getTitle());
        noticeInfoDto.setContent(notice.getContent());

        HashMap<Integer, String> documentMap = new HashMap<>();
        for(Document document : documents){
            documentMap.put(document.getId(), document.getFileName());
        }
        noticeInfoDto.setDocument(documentMap);

        if(notice.getPublishTime() != null){
            String publishTime = this.DateToString(notice.getPublishTime());
            noticeInfoDto.setPublishTime(publishTime);
        }

        return noticeInfoDto;
    }

    @Autowired
    public Notice NoticeInfoToNotice(NoticeInfo noticeInfoDto){
        Notice notice = new Notice();

        NoticeTypeEnum noticeType = NoticeTypeEnum.find(noticeInfoDto.getType());
        notice.setType(noticeType.getCode());

        notice.setId(noticeInfoDto.getId());
        notice.setCollage(noticeInfoDto.getCollage());
        notice.setTitle(noticeInfoDto.getTitle());
        notice.setContent(noticeInfoDto.getContent());

        Integer[] documentIdList = noticeInfoDto.getDocument().keySet().toArray(new Integer[0]);
        String documentIdStr = StringUtils.join(documentIdList, Parameter.splitChar);
        notice.setDocumentId(documentIdStr);

        Date publishTime = this.StringToDate(noticeInfoDto.getPublishTime());
        notice.setPublishTime(publishTime);

        return notice;
    }

    @Autowired
    public Requirement getRequirementFromRecruitInfo(RecruitInfo recruitInfoDto){
        return recruitInfoDto.getRequirement();
    }

    @Autowired
    public Recruitment getRecruitmentFromRecruitInfo(RecruitInfo recruitInfoDto){
        Recruitment recruitment = new Recruitment();

        Integer id = recruitInfoDto.getId();
        if(id != null){
            recruitment.setId(recruitInfoDto.getId());
        }

        recruitment.setPosition(recruitInfoDto.getPosition());
        recruitment.setWorkContent(recruitInfoDto.getWorkContent());
        recruitment.setSalary(recruitInfoDto.getSalary());
        recruitment.setWorkPlace(recruitInfoDto.getWorkPlace());

        Integer requirementId = recruitInfoDto.getRequirement().getId();
        if(requirementId != null){
            recruitment.setRequirementId(requirementId);
        }

        HashMap<String, String> company = recruitInfoDto.getCompany();
        for(String key : company.keySet()){
            String companyId = company.get(key);
            if(key != null){
                recruitment.setCompanyId(companyId);
            }
        }

        return recruitment;
    }

    @Autowired
    public RecruitInfo toRecruitInfo(Recruitment recruitment, Requirement requirement, Company company){
        RecruitInfo recruitInfoDto = new RecruitInfo();

        recruitInfoDto.setPosition(recruitment.getPosition());
        recruitInfoDto.setWorkContent(recruitment.getWorkContent());
        recruitInfoDto.setSalary(recruitment.getSalary());
        recruitInfoDto.setWorkPlace(recruitment.getWorkPlace());
        recruitInfoDto.setRequirement(requirement);

        HashMap<String, String> companyInfo = new HashMap<>();
        companyInfo.put(company.getScc(), company.getCompanyName());
        recruitInfoDto.setCompany(companyInfo);

        return recruitInfoDto;
    }

    @Autowired
    public ResumeInfo ResumeToResumeInfo(Resume resume){
        ResumeInfo resumeInfo = new ResumeInfo();

        resumeInfo.setId(resume.getId());

        String name = String.format("%s.%s",resume.getFileName(),resume.getExtension());
        resumeInfo.setFileFullName(name);

        return resumeInfo;
    }
//
//    @Autowired
//    public Document ResumeToDocument(Resume resume){
//        return new Document(resume.getContent(),
//                resume.getFileName(), resume.getExtension());
//
//
//    }

    @Autowired
    public Resume DocumentToResume(Document document, FlagEnum flagEnum){
        Resume resume = new Resume();

        resume.setContent(document.getContent());
        resume.setFileName(document.getFileName());
        resume.setExtension(document.getExtension());
        resume.setFlag(flagEnum.getCode());

        return resume;
    }
}
