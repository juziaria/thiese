package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



//@Mapper
@Service
public interface IAdminStuInfoService extends IService<Student> {
    String importStuInfo(MultipartFile file);

//    IPage<Student> getPage(IPage<Student> iPage);



}
