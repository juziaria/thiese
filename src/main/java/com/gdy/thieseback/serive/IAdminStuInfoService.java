package com.gdy.thieseback.serive;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Student;

public interface IAdminStuInfoService extends IService<Student> {
    void importStuInfo();

}
