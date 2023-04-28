package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.dto.Register;
import com.gdy.thieseback.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

//@Mapper
@Service
public interface ICompanyInfoService extends IService<Company> {

    String Register(Register registerDto);

    Company Login(Long scc,String pwd);

    String changePwd (ChangePwdDto changePwdDto);

    Company modifiedInfo(Company company);
}
