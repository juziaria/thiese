package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Company;
import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminNoticeService;
import com.gdy.thieseback.service.IAdminRecruitService;
import com.gdy.thieseback.util.Conversation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminRecruitServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminRecruitService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();

    @Override
    public HashMap<String, String> selectCompanyName() {
        List<Company> companyList = adminMapper.selectCompany(null, null, null, null,
                FlagEnum.Upload.getCode());

        HashMap<String, String> companyInfo = new HashMap<>();
        for (Company company : companyList) {
            companyInfo.put(company.getScc(), company.getName());
        }

        return companyInfo;
    }

    @Override
    public List<Recruit> recruitmentShow(FlagEnum flagEnum, String companyScc) {
        return adminMapper.selectRecruitments(null, flagEnum.getCode(), companyScc);
    }

    @Override
    public Boolean updateRecruitmentFlag(Integer id, FlagEnum flagEnum) {
        return adminMapper.updateRecruitmentFlag(id, flagEnum.getCode());
    }

}
