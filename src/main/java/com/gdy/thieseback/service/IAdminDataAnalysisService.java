package com.gdy.thieseback.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.gdy.thieseback.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;

//@Mapper
@Service
public interface IAdminDataAnalysisService extends IService<Admin> {
    //统计年度招聘会种类分布
    //饼图
    InputStream CountMeetingType(Integer year);

    //统计年度招聘会专业分布
    //饼图
    InputStream CountMeetingForMajor(Integer year);

    //按年级、学院、专业、工作性质（实习or正式）展示，统计就业状态分布
    //饼图
    InputStream countEmploymentStatus(Integer grade, String collage, String major,
                                      Integer workProperty);

    //按年级、学院、专业、工作性质（实习or正式）展示，统计各公司就职学生人数
    //条形图
    InputStream employmentDistributionByCompany(Integer grade, String collage, String major,
                                                Integer workProperty);

    //按年级、学院、专业、工作性质（实习or正式）展示，统计各地点就职学生人数
    //条形图
    InputStream employmentDistributionByWorkplace(Integer grade, String collage, String major,
                                                  Integer workProperty);

    //按年级、学院、专业、工作性质（实习or正式）展示，统计各行业就职学生人数
    //饼图
    InputStream employmentDistributionByIndustry(Integer grade, String collage, String major,
                                                 Integer workProperty);

    //按年级、学院、专业、工作性质（实习or正式）展示，统计岗位就职学生人数
    //条形图
    InputStream employmentDistributionByPosition(Integer grade, String collage, String major,
                                                 Integer workProperty);

    //按年级、学院、专业、工作性质（实习or正式）展示，统计各公司性质职学生人数
    //饼图
    InputStream employmentDistributionByCompanyProperty(Integer grade, String collage, String major,
                                                        Integer workProperty);

    //按工作性质（实习or正式）展示，统计各行业平均薪资
    //折线图
    InputStream salaryDistributionByIndustry(Integer workProperty);

    //按工作性质（实习or正式）展示，统计各岗位平均薪资
    //折线图
    InputStream salaryDistributionByPosition(Integer workProperty);

    //按工作性质（实习or正式）展示，统计各工作地点平均薪资
    //折线图
    InputStream salaryDistributionByWorkPlace(Integer workProperty);

    //按工作性质（实习or正式）展示，统计各公司平均薪资
    //折线图
    InputStream salaryDistributionByCompany(Integer workProperty);

    //按工作性质（实习or正式）展示，统计各公司性质平均薪资
    //折线图
    InputStream salaryDistributionByCompanyProperty(Integer workProperty);
}
