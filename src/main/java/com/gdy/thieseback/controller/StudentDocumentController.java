package com.gdy.thieseback.controller;

import com.gdy.thieseback.dto.DocumentShow;
import com.gdy.thieseback.entity.Document;
import com.gdy.thieseback.entity.Parameter;
import com.gdy.thieseback.service.IStudentDocumentService;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.util.PathHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

/**
 * 学生端控制层_文件
 */
@RestController
@RequestMapping("/gdy/stu/document")
@Api(tags = "学生端")
public class StudentDocumentController {
    @Autowired
    private IStudentDocumentService iStudentDocumentService;
    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();


    @ApiOperation("下载文件")
    @GetMapping("/downloadDocument")
    public Boolean downloadDocument(@RequestParam String saveDirPath,
                                    @RequestParam Integer id){

        return iStudentDocumentService.downloadDocument(saveDirPath, id);
    }


    @ApiOperation("文件展示")
    @GetMapping("/documentShow")
    public DocumentShow showDocuments(){
        DocumentShow documentShow = new DocumentShow();

        documentShow.count = iStudentDocumentService.selectDocumentCount(null);
        documentShow.documentInfoList = iStudentDocumentService.showDocuments(null);

        return documentShow;
    }

    @ApiOperation("文件查找")
    @GetMapping("/selectDocuments")
    public DocumentShow selectDocuments(@RequestParam String name){
        DocumentShow documentShow = new DocumentShow();

        documentShow.count = iStudentDocumentService.selectDocumentCount(name);
        documentShow.documentInfoList = iStudentDocumentService.showDocuments(name);

        return documentShow;
    }


}
