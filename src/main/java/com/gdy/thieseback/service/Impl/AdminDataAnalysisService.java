package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.myEnum.FlagEnum;
import com.gdy.thieseback.service.IAdminDataAnalysisService;
import com.gdy.thieseback.util.AddressHelper;
import com.gdy.thieseback.util.Conversation;
import com.gdy.thieseback.util.JFreeChartUtil;
import com.gdy.thieseback.util.ListHelper;
import lombok.val;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Map;

@Service
@Transactional
public class AdminDataAnalysisService extends ServiceImpl<AdminMapper, Admin> implements IAdminDataAnalysisService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();


    @Override
    public InputStream CountMeetingType(Integer year) {
        val map = adminMapper.CountMeetingType(year, FlagEnum.Delete.getCode());

        val pds = new DefaultPieDataset();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            pds.setValue(mapKey, mapValue);
        }

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(pds, 100, 100);
        jFreeChartUtil.createPieChart();
        return jFreeChartUtil.imgStream;
    }

    @Override
    public InputStream CountMeetingForMajor(Integer year) {
        val map = adminMapper.CountMeetingForMajor(year, FlagEnum.Delete.getCode());
        val majorMap = ListHelper.SpiltLastGroup(map);

        val pds = new DefaultPieDataset();

        for (Map.Entry<String, Integer> entry : majorMap.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            pds.setValue(mapKey, mapValue);
        }

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(pds, 100, 100);
        jFreeChartUtil.createPieChart();
        return jFreeChartUtil.imgStream;
    }

    @Override
    public InputStream countEmploymentStatus(Integer grade, String collage, String major, Integer workProperty) {
        val map = adminMapper.countEmploymentStatus(grade, collage, major,
                workProperty, FlagEnum.Upload.getCode());

        val pds = new DefaultPieDataset();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            pds.setValue(mapKey, mapValue);
        }

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(pds, 100, 100);
        jFreeChartUtil.createPieChart();
        return jFreeChartUtil.imgStream;
    }

    @Override
    public InputStream employmentDistributionByCompany(Integer grade, String collage, String major, Integer workProperty) {
        val map = adminMapper.employmentDistributionByCompany(
                grade, collage, major, workProperty);

        val ds = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            ds.setValue(mapValue, "", mapKey);
        }

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(ds, 100, 100,"人数","公司");
        jFreeChartUtil.createBarChart();
        return jFreeChartUtil.imgStream;
    }

    @Override
    public InputStream employmentDistributionByWorkplace(Integer grade, String collage, String major, Integer workProperty) {
        val map = adminMapper.employmentDistributionByWorkplace(
                grade, collage, major, workProperty);

        val addressMap = ListHelper.SpiltLastGroup(map);

        val ds = new DefaultCategoryDataset();

        for(Map.Entry<String, Integer> entry : addressMap.entrySet()){
            String address = entry.getKey();
            Integer count = entry.getValue();

            AddressHelper addressHelper = new AddressHelper(address);

            ds.setValue(count, "", addressHelper.getPlace());
        }

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(ds, 100, 100,"人数","工作地点");
        jFreeChartUtil.createBarChart();
        return jFreeChartUtil.imgStream;
    }

    @Override
    public InputStream employmentDistributionByIndustry(Integer grade, String collage, String major, Integer workProperty) {
        return null;
    }

    @Override
    public InputStream employmentDistributionByPosition(Integer grade, String collage, String major, Integer workProperty) {
        return null;
    }

    @Override
    public InputStream employmentDistributionByCompanyProperty(Integer grade, String collage, String major, Integer workProperty) {
        return null;
    }
}
