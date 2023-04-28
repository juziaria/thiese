package com.gdy.thieseback.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.ResumeInfo;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Mapper
@Service
public interface IAdminResumeService extends IService<Admin> {
    /**
     *浏览简历库
     */
    List<ResumeInfo> showResumes();
    /**
     *删除简历
     */
    Boolean deleteResume(Integer id);
    /**
     *下载简历
     */
    Boolean downLoadResume(Integer id, String diePath);
    /**
     *上传简历
     */
    Boolean upLoadResume(Resume resume);
}
