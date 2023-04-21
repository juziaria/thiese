package com.gdy.thieseback.controller;


import com.gdy.thieseback.service.IStudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生端控制层
 */



@Api(tags = "学生端")
@RestController
@RequestMapping("/gdy/student")
public class StudentController {
    @Autowired
    private IStudentInfoService iStudentInfoService;


    @ApiOperation("就业手续下载")
    @GetMapping("/downloadDocument")
    public Boolean downloadDocument(@RequestParam String savaDirPath,
                                    @RequestParam Integer id,
                                    @RequestParam Integer currentPage){
        return iStudentInfoService.downloadDocument(savaDirPath,id);
    }


//    @ApiOperation("文件展示")
//    public DocumentShowDto showDocuments(@RequestParam Integer currentPage){
//        DocumentShowDto documentShowDto = new DocumentShowDto();
//        documentShowDto.count = iStudentInfoService.showDocument();
//    }





}
