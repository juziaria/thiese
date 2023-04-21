package com.gdy.thieseback.controller;

import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.AdminService;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.util.MyPath;
import com.gdy.thieseback.entity.Admin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 管理员控制层
 */
@RestController
@RequestMapping("/gdy/admin")
@Api(tags = "管理员端")
public class AdminController{
    @Autowired
    private AdminService adminService;
    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();

    @ApiOperation("登录")
    @GetMapping("/login")
    public Admin login(@RequestParam String id, @RequestParam String pwd){
        return adminService.login(id, pwd);
    }

    @ApiOperation("删除学生")
    @GetMapping("/deleteStudents")
    public String deleteStudents(@RequestParam String id){
        String[] idArray = id.split(Parameter.splitChar);
        return adminService.deleteStudents(idArray);
    }

    @ApiOperation("删除公司")
    @GetMapping("/deleteCompanies")
    public String deleteCompanies(@RequestParam String id){
        String[] idArray = id.split(Parameter.splitChar);
        return adminService.deleteCompany(idArray);
    }

    @ApiOperation("学生信息筛查")
    @GetMapping("/selectStu")
    public StuShow SelectStu(@RequestParam Integer grade,
                             @RequestParam String collage,
                             @RequestParam String major,
                             @RequestParam Integer stuClass) {
        StuShow stuShow = new StuShow();
        stuShow.stuInfoList = adminService.SelectStu(grade, collage, major, stuClass);
        stuShow.collage = adminService.selectStuCollage();
        stuShow.grade = adminService.selectStuGrade();
        stuShow.major = adminService.selectStuMajor();
        stuShow.stuClass = adminService.selectStuClass();

        return stuShow;
    }

    @ApiOperation("公司信息筛查")
    @GetMapping("/selectCompany")
    public CompanyShow SelectCompany(@RequestParam String start,
                                     @RequestParam String end,
                                     @RequestParam String address) {
        Date startTime = conversation.StringToDate(start);
        Date endTime = conversation.StringToDate(end);

        CompanyShow companyShow = new CompanyShow();
        companyShow.companyInfoList = adminService.SelectCompany(startTime, endTime, address);
        companyShow.companyAddresses = adminService.selectCompanyAddress();

        return companyShow;
    }

    @ApiOperation("设置学生初始密码")
    @GetMapping("/initialStuPassword")
    public Boolean initialStuPassword(@RequestParam String id){
        return adminService.initialStuPassword(id);
    }

    @ApiOperation("密码初始化")
    @GetMapping("/initialCompanyPassword")
    public Boolean initialCompanyPassword(@RequestParam String id){
        return adminService.initialCompanyPassword(id);
    }

    @ApiOperation("更新学生信息")
    @PostMapping("/updateStu")
    public Boolean updateStu(@RequestBody StuInfo stuInfo){
        return adminService.updateStu(stuInfo);
    }

    @ApiOperation("更新公司信息")
    @PostMapping("/updateCompany")
    public Boolean updateCompany(@RequestBody CompanyInfo companyInfo){
        return adminService.updateCompany(companyInfo);
    }

    @ApiOperation("上传文件")
    @GetMapping("/uploadDocument")
    public Boolean documentUpload(@RequestParam String documentPath){
        MyPath filePath = new MyPath(documentPath);
        File file = new File(filePath.getPath());
        if(file.exists() && file.isFile()){
            Document document = new Document(file);
            return adminService.uploadDocument(document);
        }

        return false;
    }

    @ApiOperation("下载文件")
    @GetMapping("/downloadDocument")
    public Boolean downloadDocument(@RequestParam String saveDirPath,
                                    @RequestParam Integer id){
        return adminService.downloadDocument(saveDirPath, id);
    }

    @ApiOperation("删除文件")
    @GetMapping("/deleteDocument")
    public Boolean deleteDocument(@RequestParam Integer id){
        return adminService.deleteDocument(id);
    }

    @ApiOperation("文件展示")
    @GetMapping("/documentShow")
    public DocumentShow showDocuments(){
        DocumentShow documentShow = new DocumentShow();

        documentShow.count = adminService.selectDocumentCount();
        documentShow.documentInfoList = adminService.showDocuments();

        return documentShow;
    }

    @ApiOperation("展示所有已经发布了的通知")
    @GetMapping("/showNotices")
    public HashMap<Integer, String> showNotices(){
        return this.noticeShow(FlagEnum.Publish);
    }

    @ApiOperation("展示所有未发布的通知，即草稿箱")
    @GetMapping("/showDraft")
    public HashMap<Integer, String> showDraft(){
        return this.noticeShow(FlagEnum.NotPublish);
    }

    private HashMap<Integer, String> noticeShow(FlagEnum flagEnum){
        HashMap<Integer, String> result = new HashMap<>();

        List<Notice> notices = adminService.selectNotice(null, flagEnum);
        for(Notice notice : notices){
            result.put(notice.getId(), notice.getTitle());
        }

        return result;
    }

    @ApiOperation("查看具体通知")
    @GetMapping("/selectNotice")
    public NoticeInfo selectNotice(@RequestParam Integer id){
        Notice notice = adminService.selectNotice(id, null).get(0);

        List<Document> documents = new ArrayList<>();
        String[] documentIdList = notice.getDocumentId().split(Parameter.splitChar);
        for(String documentIdStr : documentIdList){
            Integer documentId = Integer.parseInt(documentIdStr);
            documents.add(adminService.selectDocument(documentId));
        }

        return conversation.NoticeToNoticeInfo(notice, documents);
    }

    @ApiOperation("发布通知")
    @PostMapping("/publishNotice")
    public Boolean publishNotice(@RequestBody NoticeInfo noticeInfo){
        Notice notice = conversation.NoticeInfoToNotice(noticeInfo);
        notice.setFlag(FlagEnum.Publish.getCode());

        return adminService.insertNotice(notice);
    }

    @ApiOperation("保存到草稿箱")
    @PostMapping("/saveToDraft")
    public Boolean saveToDraft(@RequestBody NoticeInfo noticeInfo){
        Notice notice = conversation.NoticeInfoToNotice(noticeInfo);
        notice.setFlag(FlagEnum.NotPublish.getCode());

        List<Notice> notices = adminService.selectNotice(notice.getId(), FlagEnum.NotPublish);
        if(notices.size() > 0){
            return adminService.updateNotice(notice);
        }
        else {
            return adminService.insertNotice(notice);
        }
    }

    @ApiOperation("撤回通知")
    @GetMapping("/withdrawNotice")
    public Boolean withdrawNotice(@RequestParam Integer id){
        return adminService.updateNoticeState(id, FlagEnum.NotPublish);
    }

    @ApiOperation("重新发布通知")
    @PostMapping("/rePublishNotice")
    public Boolean rePublishNotice(@RequestBody NoticeInfo noticeInfo){
        Notice notice = conversation.NoticeInfoToNotice(noticeInfo);

        adminService.updateNotice(notice);
        return adminService.updateNoticeState(notice.getId(), FlagEnum.Publish);
    }

    @ApiOperation("删除通知")
    @GetMapping("/deleteNotice")
    public Boolean deleteNotice(@RequestParam Integer id){
        return adminService.updateNoticeState(id, FlagEnum.Delete);
    }

    @ApiOperation("修改通知")
    @PostMapping("/updateNotice")
    public Boolean updateNotice(@RequestBody NoticeInfo noticeInfo){
        Notice notice = conversation.NoticeInfoToNotice(noticeInfo);
        return adminService.updateNotice(notice);
    }

    @ApiOperation("返回公司列表")
    @GetMapping("/selectCompanyName")
    public HashMap<String, String> selectCompanyName(){
        return adminService.selectCompanyName();
    }

    @ApiOperation("返回工作地点列表")
    @GetMapping("/selectWorkPlace")
    List<String> selectWorkPlace(){
        return adminService.selectWorkPlace();
    }

    @ApiOperation("发布招聘信息")
    @PostMapping("/publishRecruitment")
    public Boolean publishRecruitment(@RequestBody RecruitInfo recruitInfo){
        Recruitment recruitment = conversation.getRecruitmentFromRecruitInfo(recruitInfo);
        Requirement requirement = conversation.getRequirementFromRecruitInfo(recruitInfo);
        return adminService.publishRecruitment(recruitment, requirement);
    }

    @ApiOperation("浏览招聘信息")
    @GetMapping("/recruitmentShow")
    public List<RecruitInfo> recruitmentShow(@RequestParam String flagContent,
                                             @RequestParam Integer salaryMin,
                                             @RequestParam Integer salaryMAX,
                                             @RequestParam String workPlace){
        if(flagContent != null && !flagContent.equals("")){
            FlagEnum flagEnum = FlagEnum.find(flagContent);

            return adminService.recruitmentShow(flagEnum, salaryMin, salaryMAX, workPlace);
        }

        return new ArrayList<RecruitInfo>();
    }

    @ApiOperation("驳回")
    @GetMapping("/rejectRecruitment")
    public Boolean rejectRecruitment(@RequestParam Integer id){
        return adminService.updateRecruitmentFlag(id, FlagEnum.Reject);
    }

    @ApiOperation("结束")
    @GetMapping("/endRecruitment")
    public Boolean endRecruitment(@RequestParam Integer id){
        return adminService.updateRecruitmentFlag(id, FlagEnum.End);
    }

    @ApiOperation("发布")
    @GetMapping("/publishRecruitment")
    public Boolean publishRecruitment(@RequestParam Integer id){
        return adminService.updateRecruitmentFlag(id, FlagEnum.Publish);
    }

    @ApiOperation("浏览简历")
    @GetMapping("/showResumes")
    public List<ResumeInfo> showResumes(){
        return adminService.showResumes();
    }

    @ApiOperation("删除简历")
    @GetMapping("/deleteResume")
    public Boolean deleteResume(@RequestParam Integer id){
        return adminService.deleteResume(id);
    }

    @ApiOperation("下载简历")
    @GetMapping("/downloadResume")
    public Boolean downloadResume(@RequestParam Integer id,
                                  @RequestParam String dirPath){
        return adminService.downLoadResume(id, dirPath);
    }

    @ApiOperation("上传简历")
    @GetMapping("/uploadResume")
    public Boolean uploadResume(@RequestParam String resumePath){
        MyPath filePath = new MyPath(resumePath);
        File file = new File(filePath.getPath());
        if(file.exists() && file.isFile()){
            Document document = new Document(file);
            Resume resume = conversation.DocumentToResume(document, FlagEnum.Upload);

            return adminService.upLoadResume(resume);
        }
        return false;
    }


}
