package com.gdy.thieseback.service.Impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;

import com.alibaba.excel.read.metadata.ReadSheet;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Student;
import com.gdy.thieseback.mapper.AdminStuInfoMapper;
import com.gdy.thieseback.service.IAdminStuInfoService;
import com.gdy.thieseback.service.IStudentInfoService;
import com.gdy.thieseback.util.Encrypt;
import com.gdy.thieseback.util.ImportListen;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminStuInfoServiceImpl extends ServiceImpl<AdminStuInfoMapper, Student> implements IAdminStuInfoService {

    @Autowired
    public IStudentInfoService studentInfoService;

    Encrypt encrypt =new Encrypt();

    //导入学生信息，分页返回
    @Override
    public String importStuInfo(MultipartFile file){
        ExcelReader excelReader = null;
        List<String> errorMessage = new ArrayList<>();
        try {
            excelReader= EasyExcel.read(file.getInputStream(), Student.class,new ImportListen(errorMessage,studentInfoService)).build();
            for (int i = 0; i <excelReader.excelExecutor().sheetList().size() ; i++) {
                ReadSheet readSheet = EasyExcel.readSheet(i).headRowNumber(1).build();
                excelReader.read(readSheet);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(excelReader!=null){
                excelReader.finish();
            }
        }
        return "学生信息导入完成！";
    }
    //一键初始化学生密码

    //修改学生信息
}










