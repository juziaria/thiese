package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public interface AdminService extends IService<Admin> {
    /**
     * 上传文件
     */
    Boolean uploadDocument(Document document);
    /**
     * 下载文件
     */
    Boolean downloadDocument(String saveDirPath, Integer id);
    /**
     * 删除文件
     */
    Boolean deleteDocument(Integer id);
    /**
     * 文件查询
     */
    List<DocumentInfo> showDocuments();
    Document selectDocument(Integer id);
    /**
     * 文件数量查询
     */
    Integer selectDocumentCount();
    /**
     * 查询通知
     */
    List<Notice> selectNotice(Integer id, FlagEnum flagEnum);
    /**
     * 发布通知
     */
    Boolean insertNotice(Notice notice);
    /**
     * 修改通知状态
     */
    Boolean updateNoticeState(Integer id, FlagEnum flagEnum);
    /**
     * 修改通知
     */
    Boolean updateNotice(Notice notice);
    /**
     * 返回公司列表
     */
    HashMap<String, String> selectCompanyName();
    /**
     *展示招聘信息（需二次处理）
     */
    List<Recruit> recruitmentShow(FlagEnum flagEnum, String companyScc, String major);
    /**
     *修改招聘信息状态
     */
    Boolean updateRecruitmentFlag(Integer id, FlagEnum flagEnum);
    /**
     *浏览简历库
     */
    List<ResumeInfo> showResumes();
    /**
     *删除简历
     */
    Boolean deleteResume(Integer id);
    /**
     *下载简历
     */
    Boolean downLoadResume(Integer id, String diePath);
    /**
     *上传简历
     */
    Boolean upLoadResume(Resume resume);
    /**
     *浏览会议信息
     */
    List<MeetingInfo> showMeeting(FlagEnum flagEnum);
    /**
     *删除会议信息
     */
    void deleteMeeting(Integer id);
    /**
     *分配教室，并发布
     */
    Boolean EnsureMeeting(Integer id, Integer classroomId);
    /**
     *查询空教室
     */
    List<String> showAdvices(Integer grade);
    /**
     *是否打开问卷填写
     */
    Boolean updateIfOpenQuestionnaire(Boolean value);
}
