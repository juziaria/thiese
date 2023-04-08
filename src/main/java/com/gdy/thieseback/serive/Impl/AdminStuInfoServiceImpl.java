package com.gdy.thieseback.serive.Impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Student;
import com.gdy.thieseback.mapper.AdminStuInfoMapper;
import com.gdy.thieseback.serive.IAdminStuInfoService;
import com.gdy.thieseback.until.Encrypt;
import org.springframework.stereotype.Service;

@Service
public class AdminStuInfoServiceImpl extends ServiceImpl<AdminStuInfoMapper, Student> implements IAdminStuInfoService {

    Encrypt encrypt =new Encrypt();

    //导入学生信息，分页返回
    @Override
    public void importStuInfo(){
        ExcelReaderBuilder readerBuilder = EasyExcel.read();
    }

    //一键初始化学生密码


    //修改学生信息




}
