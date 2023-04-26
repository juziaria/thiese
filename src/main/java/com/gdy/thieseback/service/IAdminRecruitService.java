package com.gdy.thieseback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.entity.Recruit;
import com.gdy.thieseback.myEnum.FlagEnum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface IAdminRecruitService extends IService<Admin> {

    /**
     * 返回公司列表
     */
    HashMap<String, String> selectCompanyName();
    /**
     *展示招聘信息（需二次处理）
     */
    List<Recruit> recruitmentShow(FlagEnum flagEnum, String companyScc);
    /**
     *修改招聘信息状态
     */
    Boolean updateRecruitmentFlag(Integer id, FlagEnum flagEnum);
}
