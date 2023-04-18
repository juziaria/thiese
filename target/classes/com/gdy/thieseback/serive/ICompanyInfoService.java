package com.gdy.thieseback.serive;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.dto.ChangePwdDto;
import com.gdy.thieseback.dto.RegisterDto;
import com.gdy.thieseback.entity.Company;

public interface ICompanyInfoService extends IService<Company> {

    String Register(RegisterDto registerDto);

    Company Login(Long scc,String pwd);

    String changePwd (ChangePwdDto changePwdDto);

    Company modifiedInfo(Company company);
}
