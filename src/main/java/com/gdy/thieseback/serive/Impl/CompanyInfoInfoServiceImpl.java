package com.gdy.thieseback.serive.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.dto.RegisterDto;
import com.gdy.thieseback.entity.Company;
import com.gdy.thieseback.mapper.CompanyInfoMapper;
import com.gdy.thieseback.serive.ICompanyInfoService;
import com.gdy.thieseback.until.Encrypt;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CompanyInfoInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, Company> implements ICompanyInfoService {

    Encrypt encrypt = new Encrypt();

    @Override
    public String Register(RegisterDto registerDto){
        Company company = baseMapper.selectById(registerDto.getScc());
        if (company!=null){
            return "该企业已注册！是否忘记密码";
        }else{
             baseMapper.insertSelf(registerDto.getScc());
        }
        String salt = UUID.randomUUID().toString().toUpperCase();
        String pwd = encrypt.getMD5(registerDto.getCompanyPwd(), salt);
        company = baseMapper.selectById(registerDto.getScc());
        company.setCompanyPwd(pwd);
        company.setCompanyName(registerDto.getCompanyName());
        company.setSalt(salt);
        company.setDeleted(0);
        company.setCreateTime(new Date());
        company.setCreateUser(registerDto.getScc());
        baseMapper.updateById(company);
        return "注册成功，请完善其他信息";
    }
    //登录
    @Override
    public Company Login(Long scc,String pwd){
        Company res = baseMapper.selectById(scc);
         if(res!=null && res.getDeleted().equals(1)){
            throw new RuntimeException("该用户已被删除！");
        }else if(res==null){
             throw new RuntimeException("该用户不存在，请先注册。");
         }
         String checkPwd = encrypt.getMD5(pwd, res.getSalt());
         if (!checkPwd.equals(res.getCompanyPwd())){
             throw  new RuntimeException("密码错误！");
         }
        return res;
    }


    //修改密码
    @Override
    public String changePwd(ChangePwdDto changePwdDto){
       Company res = baseMapper.selectById(changePwdDto.getId());
       String checkPwd =encrypt.getMD5(changePwdDto.getOldPwd(),res.getSalt());
       if (!checkPwd.equals(res.getCompanyPwd())){
           return "原密码错误";
       }
       String salt = encrypt.getSalt();
       String newPwd = encrypt.getMD5(changePwdDto.getNewPwd(),salt);
       res.setSalt(salt);
       res.setCompanyPwd(newPwd);
       res.setModifiedTime(new Date());
       res.setModifiedUser(changePwdDto.getId());
       baseMapper.updateById(res);
       return "密码修改成功";
    }

    //修改个人资料
    public Company modifiedInfo(Company company){
        company.setModifiedUser(company.getScc());
        company.setModifiedTime(new Date());
        baseMapper.modifiedInfo(company);
        baseMapper.updateById(company);
        return company;
    }
}
