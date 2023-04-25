package com.gdy.thieseback.controller;


import com.gdy.thieseback.dto.ResumeInfo;
import com.gdy.thieseback.entity.Document;
import com.gdy.thieseback.entity.Parameter;
import com.gdy.thieseback.entity.Resume;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminRecruitService;
import com.gdy.thieseback.service.IAdminResumeService;
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
import java.util.List;

/**
 * 管理员控制层_简历
 */
@RestController
@RequestMapping("/gdy/admin")
@Api(tags = "管理员端")
public class AdminResumeController {
    @Autowired
    private IAdminResumeService IAdminResumeService;

    private final Conversation conversation = new Conversation();
    private final Parameter p = new Parameter();




    @ApiOperation("浏览简历")
    @GetMapping("/showResumes")
    public List<ResumeInfo> showResumes(){
        return IAdminResumeService.showResumes();
    }

    @ApiOperation("删除简历")
    @GetMapping("/deleteResume")
    public Boolean deleteResume(@RequestParam Integer id){
        return IAdminResumeService.deleteResume(id);
    }

    @ApiOperation("下载简历")
    @GetMapping("/downloadResume")
    public Boolean downloadResume(@RequestParam Integer id,
                                  @RequestParam String dirPath){
        return IAdminResumeService.downLoadResume(id, dirPath);
    }

    @ApiOperation("上传简历")
    @GetMapping("/uploadResume")
    public Boolean uploadResume(@RequestParam String resumePath){
        PathHelper filePath = new PathHelper(resumePath);
        File file = new File(filePath.getPath());
        if(file.exists() && file.isFile()){
            Document document = new Document(file);
            Resume resume = conversation.DocumentToResume(document, FlagEnum.Upload);

            return IAdminResumeService.upLoadResume(resume);
        }
        return false;
    }
}
