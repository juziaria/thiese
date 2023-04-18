package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.entity.Student;

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
}
