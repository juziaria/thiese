package com.gdy.thieseback.controller;

import com.gdy.thieseback.dto.NoticeInfo;
import com.gdy.thieseback.entity.Document;
import com.gdy.thieseback.entity.Notice;
import com.gdy.thieseback.entity.Parameter;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.myEnum.NoticeTypeEnum;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.service.IAdminNoticeService;
import com.gdy.thieseback.util.Conversation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 管理员控制层_通知
 */
@RestController
@RequestMapping("/gdy/admin")
@Api(tags = "管理员端")
public class AdminNoticeController {
    @Autowired
    private IAdminNoticeService IAdminNoticeService;

    @Autowired
    private IAdminDocumentService IAdminDocumentService;

    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();


    @ApiOperation("预览已发布的通知")
    @GetMapping("/showNotices")
    public List<NoticeInfo> showNotices(){
        return this.noticeShow(FlagEnum.Publish);
    }

    @ApiOperation("预览草稿箱")
    @GetMapping("/showDraft")
    public List<NoticeInfo> showDraft(){
        return this.noticeShow(FlagEnum.NotPublish);
    }

    private List<NoticeInfo> noticeShow(FlagEnum flagEnum){
        List<NoticeInfo> noticeInfoList = new ArrayList<>();
        List<Notice> notices = IAdminNoticeService.selectNotice(null, flagEnum);
        for(Notice notice : notices){
            String[] documentIdList = notice.getDocumentId().split(Parameter.splitChar);

            List<Document> documentList = new ArrayList<>();
            for(String documentIdStr : documentIdList){
                Integer documentId = Integer. parseInt(documentIdStr);
                Document document = IAdminDocumentService.selectDocument(documentId, null);

                if(document != null){
                    documentList.add(document);
                }
            }

            noticeInfoList.add(conversation.NoticeToNoticeInfo(notice, documentList));
        }

        return noticeInfoList;
    }


    @ApiOperation("筛选已发布的通知")
    @GetMapping("/selectPublishNotices")
    public List<NoticeInfo> selectPublishNotices(@RequestParam String type,
                                                 @RequestParam String name,
                                                 @RequestParam Integer day){
        return this.selectNotices(type, name, day, FlagEnum.Publish);
    }

    @ApiOperation("筛选草稿箱")
    @GetMapping("/selectDraft")
    public List<NoticeInfo> selectDraft(@RequestParam String name){
        return this.selectNotices(null, name, null, FlagEnum.NotPublish);
    }

    private List<NoticeInfo> selectNotices(String type, String name, Integer day, FlagEnum flagEnum) {
        List<NoticeInfo> noticeInfoList = new ArrayList<>();

        NoticeTypeEnum noticeTypeEnum = NoticeTypeEnum.find(type);
        List<Notice> notices = IAdminNoticeService.selectNotice(noticeTypeEnum, name, day, flagEnum);

        for(Notice notice : notices){
            List<Document> documents = new ArrayList<>();

            String[] documentIdList = notice.getDocumentId().split(Parameter.splitChar);
            for(String documentIdStr : documentIdList){
                Integer documentId = Integer.parseInt(documentIdStr);

                documents.add(IAdminDocumentService.selectDocument(documentId, null));
            }

            noticeInfoList.add(conversation.NoticeToNoticeInfo(notice, documents));
        }

        return noticeInfoList;
    }

    @ApiOperation("发布通知")
    @PostMapping("/publishNotice")
    public Boolean publishNotice(@RequestBody NoticeInfo noticeInfo){
        Notice notice = conversation.NoticeInfoToNotice(noticeInfo);
        notice.setFlag(FlagEnum.Publish.getCode());

        Integer noticeId = IAdminNoticeService.insertNotice(notice);

        return IAdminNoticeService.updateNoticeState(noticeId, FlagEnum.Publish);
    }

    @ApiOperation("保存到草稿箱")
    @PostMapping("/saveToDraft")
    public Boolean saveToDraft(@RequestBody NoticeInfo noticeInfo){
        Notice notice = conversation.NoticeInfoToNotice(noticeInfo);
        notice.setFlag(FlagEnum.NotPublish.getCode());

        List<Notice> notices = IAdminNoticeService.selectNotice(notice.getId(), FlagEnum.NotPublish);
        if(notices.size() > 0){
            return IAdminNoticeService.updateNotice(notice);
        }
        else {
            Integer noticeId = IAdminNoticeService.insertNotice(notice);
            return IAdminNoticeService.updateNoticeState(noticeId, FlagEnum.Publish);
        }
    }

    @ApiOperation("撤回通知")
    @GetMapping("/withdrawNotice")
    public Boolean withdrawNotice(@RequestParam Integer id){
        return IAdminNoticeService.updateNoticeState(id, FlagEnum.NotPublish);
    }

    @ApiOperation("重新发布通知")
    @PostMapping("/rePublishNotice")
    public Boolean rePublishNotice(@RequestBody NoticeInfo noticeInfo){
        Notice notice = conversation.NoticeInfoToNotice(noticeInfo);

        IAdminNoticeService.updateNotice(notice);

        return IAdminNoticeService.updateNoticeState(notice.getId(), FlagEnum.Publish);
    }

    @ApiOperation("删除通知")
    @GetMapping("/deleteNotice")
    public Boolean deleteNotice(@RequestParam Integer id){
        return IAdminNoticeService.updateNoticeState(id, FlagEnum.Delete);
    }

    @ApiOperation("修改通知")
    @PostMapping("/updateNotice")
    public Boolean updateNotice(@RequestBody NoticeInfo noticeInfo){
        Notice notice = conversation.NoticeInfoToNotice(noticeInfo);
        return IAdminNoticeService.updateNotice(notice);
    }
}
