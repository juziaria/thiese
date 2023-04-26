package com.gdy.thieseback.controller;

import com.gdy.thieseback.dto.*;
import com.gdy.thieseback.entity.*;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminDocumentService;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.util.PathHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 管理员控制层_文件
 */
@RestController
@RequestMapping("/gdy/admin/document")
@Api(tags = "管理员端")
public class AdminDocumentController {
    @Autowired
    private IAdminDocumentService IAdminDocumentService;
    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();

    @ApiOperation("上传文件")
    @GetMapping("/uploadDocument")
    public Boolean documentUpload(@RequestParam String documentPath){
        PathHelper filePath = new PathHelper(documentPath);
        File file = new File(filePath.getPath());
        if(file.exists() && file.isFile()){
            Document document = new Document(file);
            return IAdminDocumentService.uploadDocument(document);
        }

        return false;
    }

    @ApiOperation("下载文件")
    @GetMapping("/downloadDocument")
    public Boolean downloadDocument(@RequestParam String saveDirPath,
                                    @RequestParam Integer id){
        return IAdminDocumentService.downloadDocument(saveDirPath, id);
    }

    @ApiOperation("删除文件")
    @GetMapping("/deleteDocument")
    public Boolean deleteDocument(@RequestParam Integer id){
        return IAdminDocumentService.deleteDocument(id);
    }

    @ApiOperation("文件展示")
    @GetMapping("/documentShow")
    public DocumentShow showDocuments(){
        DocumentShow documentShow = new DocumentShow();

        documentShow.count = IAdminDocumentService.selectDocumentCount(null);
        documentShow.documentInfoList = IAdminDocumentService.showDocuments(null);

        return documentShow;
    }

    @ApiOperation("文件查找")
    @GetMapping("/selectDocuments")
    public DocumentShow selectDocuments(@RequestParam String name){
        DocumentShow documentShow = new DocumentShow();

        documentShow.count = IAdminDocumentService.selectDocumentCount(name);
        documentShow.documentInfoList = IAdminDocumentService.showDocuments(name);

        return documentShow;
    }
}
