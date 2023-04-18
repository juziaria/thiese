package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Student;
import org.springframework.web.multipart.MultipartFile;




public interface IAdminStuInfoService extends IService<Student> {
    String importStuInfo(MultipartFile file);

//    IPage<Student> getPage(IPage<Student> iPage);



}
