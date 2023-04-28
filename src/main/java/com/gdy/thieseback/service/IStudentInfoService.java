package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

//@Mapper
@Service
public interface IStudentInfoService extends IService<Student> {

    /**
     * 登录
     * @param id
     * @param studentPwd
     * @return
     */
    Student login(Long id,String studentPwd);

    /**
     * 修改密码
     * @param changePwdDto
     * @return
     */
    String changePwd(ChangePwdDto changePwdDto);


    /**
     * 修改学生个人信息
     * @param student
     * @return
     */
    Student stuInfo(Student student);


    /**
     *
     * 就业手续下载
     *
     */
    Boolean downloadDocument(String saveDirPath,Integer id);

    /**
     * 文件查询
     */
    //List<DocumentInfoDto> showDocuments();
}
