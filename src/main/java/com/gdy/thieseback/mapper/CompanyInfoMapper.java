package com.gdy.thieseback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdy.thieseback.entity.Company;
import org.apache.ibatis.annotations.Param;

public interface CompanyInfoMapper extends BaseMapper<Company> {

    void insertSelf(@Param("scc") Long scc);

    void modifiedInfo(@Param("company")Company company);
}
