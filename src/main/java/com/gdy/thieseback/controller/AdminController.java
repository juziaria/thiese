package com.gdy.thieseback.controller;

import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.AdminService;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.util.PathHelper;
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

    @ApiOperation("上传文件")
    @GetMapping("/uploadDocument")
    public Boolean documentUpload(@RequestParam String documentPath){
        PathHelper filePath = new PathHelper(documentPath);
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

    @ApiOperation("浏览招聘信息")
    @GetMapping("/recruitmentShow")
    public List<Recruit> recruitmentShow(@RequestParam String flagContent,
                                         @RequestParam String companyScc,
                                         @RequestParam String major){
        if(flagContent != null && !flagContent.equals("")){
            FlagEnum flagEnum = FlagEnum.find(flagContent);

            return adminService.recruitmentShow(flagEnum, companyScc, major);
        }

        return new ArrayList<>();
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
        PathHelper filePath = new PathHelper(resumePath);
        File file = new File(filePath.getPath());
        if(file.exists() && file.isFile()){
            Document document = new Document(file);
            Resume resume = conversation.DocumentToResume(document, FlagEnum.Upload);

            return adminService.upLoadResume(resume);
        }
        return false;
    }

    @ApiOperation("浏览未发布会议")
    @GetMapping("/showNotPublishMeeting")
    public List<MeetingInfo> showNotPublishMeeting(){
        return adminService.showMeeting(FlagEnum.NotPublish);
    }

    @ApiOperation("浏览发布，但未开始会议")
    @GetMapping("/showNotStartedMeeting")
    public List<MeetingInfo> showNotStartedMeeting(){
        return adminService.showMeeting(FlagEnum.NotStarted);
    }

    @ApiOperation("浏览正在进行的会议")
    @GetMapping("/showInProgressMeeting")
    public List<MeetingInfo> showInProgressMeeting(){
        return adminService.showMeeting(FlagEnum.InProgress);
    }

    @ApiOperation("浏览已结束的会议")
    @GetMapping("/showEndMeeting")
    public List<MeetingInfo> showEndMeeting(){
        return adminService.showMeeting(FlagEnum.End);
    }

    @ApiOperation("删除指定会议")
    @GetMapping("/delectMeeting")
    public Boolean delectMeeting(@RequestParam Integer id){
        try {
            adminService.deleteMeeting(id);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public Boolean ensureMeeting(@RequestParam Integer id,
                                 @RequestParam Integer classroomId){
        return adminService.EnsureMeeting(id, classroomId);
    }

    @ApiOperation("查看空教室")
    @GetMapping("/showEmptyClassroom")
    public HashMap<Integer, String> showEmptyClassroom(){
        return adminService.showEmptyClassroom();
    }

    @ApiOperation("查看问卷中的建议")
    @GetMapping("/showEmptyClassroom")
    public List<String> showAdvices (@RequestParam Integer grade){
        return adminService.showAdvices(grade);
    }

    @ApiOperation("开启问卷")
    @GetMapping("/openQuestionnaire")
    public Boolean openQuestionnaire(){
        return adminService.updateIfOpenQuestionnaire(true);
    }

    @ApiOperation("关闭问卷")
    @GetMapping("/closeQuestionnaire")
    public Boolean closeQuestionnaire(){
        return adminService.updateIfOpenQuestionnaire(false);
    }
}
