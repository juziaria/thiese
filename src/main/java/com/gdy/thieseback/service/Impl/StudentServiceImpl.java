package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.entity.Document;
import com.gdy.thieseback.entity.Student;
import com.gdy.thieseback.mapper.StudentInfoMapper;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IStudentInfoService;
import com.gdy.thieseback.util.Encrypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentInfoMapper, Student> implements IStudentInfoService{

    Encrypt encrypt = new Encrypt();
    @Resource
    private StudentInfoMapper studentInfoMapper;


    /**
     * 登录
     * @param id
     * @param studentPwd
     * @return
     */
    @Override
    public Student login(Long id,String studentPwd){
        Student res = baseMapper.selectById(id);
        if(res==null|| res.getDeleted().equals(1)){
            throw new RuntimeException("该学生用户不存在，请联系管理员");
        }
        String checkPwd = encrypt.getMD5(studentPwd,res.getSalt());
        if(!checkPwd.equals(res.getPwd())){
            throw new RuntimeException("密码错误");
        }
        return null;
    }

    /**
     * 更改密码
     * @param changePwdDto
     * @return
     */
    @Override
    public String changePwd(ChangePwdDto changePwdDto){
        Student res = baseMapper.selectById(changePwdDto.getId());
        String checkPwd =encrypt.getMD5(changePwdDto.getOldPwd(),res.getSalt());
        if (!checkPwd.equals(res.getPwd())){
            return "原密码错误";
        }
        String salt = encrypt.getSalt();
        String newPwd = encrypt.getMD5(changePwdDto.getNewPwd(),salt);
        res.setSalt(salt);
        res.setPwd(newPwd);
        res.setModifiedTime(new Date());
        res.setModifiedUser(changePwdDto.getId());
        baseMapper.updateById(res);
        return "密码修改成功";
    }

    /**
     *修改学生个人信息
     * @param student
     * @return
     */
    @Override
    public Student stuInfo(Student student){
        student.setModifiedTime(new Date());
        student.setModifiedUser(student.getId());
        baseMapper.updateById(student);
        baseMapper.modifiedInfo(student);
        return student;
    }
   @Override
    public Boolean downloadDocument(String saveDirPath,Integer id){
       Document document = studentInfoMapper.selectDocument(id, FlagEnum.Upload.getCode()).get(0);
       String savePath = document.getSavaPath(saveDirPath);
       try {
           document.save(savePath);
       }catch (Exception EX){
           return false;
       }
       return false;
   }

//   @Override
//    public List<DocumentInfoDto> showDocuments(){
//        List<Document> documents = studentInfoMapper.selectDocument(null,FlagEnum.Upload.getCode());
//        List<DocumentInfoDto> documentInfoDtoList = new ArrayList<>();
//
//        for(Document document : documents){
//            DocumentInfoDto documentInfoDto =
//        }
//   }


}
