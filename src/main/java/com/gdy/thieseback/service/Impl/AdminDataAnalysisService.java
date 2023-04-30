package com.gdy.thieseback.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdy.thieseback.entity.Admin;
import com.gdy.thieseback.mapper.AdminMapper;
import com.gdy.thieseback.myEnum.*;
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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AdminDataAnalysisService extends ServiceImpl<AdminMapper, Admin> implements IAdminDataAnalysisService {
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private final Conversation conversation = new Conversation();

    private InputStream createPeiImg(Map<String, Integer> map){
        val pds = new DefaultPieDataset();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            pds.setValue(mapKey, mapValue);
        }

        int height = 60 * map.size();
        int width = 2 * height;

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(pds, width, height);
        jFreeChartUtil.createPieChart();

        return jFreeChartUtil.imgStream;
    }

    private InputStream createSingleBarImg(Map<String, Integer> map, String xLabel, String yLabel){
        val ds = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            ds.setValue(mapValue, "", mapKey);
        }

        int height = 60 * map.size();
        int width = 2 * height;

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(ds, width, height, xLabel, yLabel);
        jFreeChartUtil.createBarChart();
        return jFreeChartUtil.imgStream;
    }

    private InputStream createLineImg(Map<String, Integer> map, String xLabel, String yLabel){
        val ds = new DefaultCategoryDataset();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            ds.setValue(mapValue, "", mapKey);
        }

        int height = 60 * map.size();
        int width = 2 * height;

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(ds, width, height, xLabel, yLabel);
        jFreeChartUtil.createLineChart();
        return jFreeChartUtil.imgStream;
    }

    private Map<String, Integer> WorkPlaceGroup(Map<String, Integer> map, boolean isAvgSalary){
        for (val entry : map.entrySet()) {
            val mapKey = entry.getKey();
            val mapValue = entry.getValue();

            AddressHelper addressHelper = new AddressHelper(mapKey);
            val key = addressHelper.getPlace();

            map.remove(mapKey);

            if(map.containsKey(key)){
                if(isAvgSalary){
                    map.put(key, (map.get(key) + mapValue)/2);
                }
                else{
                    map.put(key, map.get(key) + mapValue);
                }
            }else{
                map.put(key, mapValue);
            }
        }

        return map;
    }

    private Map<String, Integer> EnumGroup(Map<Integer, Integer> map, EnumType enumType) {
        val newMap = new HashMap<String, Integer>();
        for (val entry : map.entrySet()) {
            val mapKey = entry.getKey();
            val mapValue = entry.getValue();

            String key = "";

            switch (enumType) {
                case MeetingType:
                    key = MeetingTypeEnum.find(mapKey).getContent();
                    break;
                case EmploymentStatus:
                    key = EmploymentStatusEnum.find(mapKey).getContent();
                    break;
                case CompanyProperty:
                    key = CompanyPropertyEnum.find(mapKey).getContent();
                    break;
            }

            if(!key.equals("")){
                newMap.put(key, mapValue);
            }
        }
        return newMap;
    }

    @Override
    public InputStream CountMeetingType(Integer year) {
        val map = adminMapper.CountMeetingType(year, FlagEnum.Delete.getCode());

        return this.createPeiImg(this.EnumGroup(map, EnumType.MeetingType));
    }

    @Override
    public InputStream CountMeetingForMajor(Integer year) {
        val map = ListHelper.MapSpiltLastGroup(
                adminMapper.CountMeetingForMajor(year, FlagEnum.Delete.getCode()));

        return this.createPeiImg(map);
    }

    @Override
    public InputStream countEmploymentStatus(Integer grade, String collage, String major, Integer workProperty) {
        val map = adminMapper.countEmploymentStatus(grade, collage, major, workProperty);

        return this.createPeiImg(this.EnumGroup(map, EnumType.EmploymentStatus));
    }

    @Override
    public InputStream employmentDistributionByCompany(Integer grade, String collage, String major, Integer workProperty) {
        val map = adminMapper.employmentDistributionByCompany(
                grade, collage, major, workProperty);

        return this.createSingleBarImg(map, "公司", "人数");
    }

    @Override
    public InputStream employmentDistributionByWorkplace(Integer grade, String collage, String major, Integer workProperty) {
        val map = ListHelper.MapSpiltLastGroup(
                adminMapper.employmentDistributionByWorkplace(grade, collage, major, workProperty));

        return this.createSingleBarImg(this.WorkPlaceGroup(map, false),
                "工作地点", "人数");
    }

    @Override
    public InputStream employmentDistributionByIndustry(Integer grade, String collage, String major, Integer workProperty) {
        val map = adminMapper.employmentDistributionByIndustry(
                grade, collage, major, workProperty);

        return this.createPeiImg(map);
    }

    @Override
    public InputStream employmentDistributionByPosition(Integer grade, String collage, String major, Integer workProperty) {
        val map = adminMapper.employmentDistributionByPosition(
                grade, collage, major, workProperty);

        return this.createSingleBarImg(map, "岗位", "人数");
    }

    @Override
    public InputStream employmentDistributionByCompanyProperty(Integer grade, String collage, String major, Integer workProperty) {
        val map = adminMapper.employmentDistributionByCompanyProperty(
                grade, collage, major, workProperty);

        return this.createPeiImg(this.EnumGroup(map, EnumType.CompanyProperty));
    }

    @Override
    public InputStream salaryDistributionByIndustry(Integer workProperty) {
        val map = adminMapper.salaryDistributionByIndustry(workProperty);
        return this.createLineImg(map, "行业", "薪资");
    }

    @Override
    public InputStream salaryDistributionByPosition(Integer workProperty) {
        val map = adminMapper.salaryDistributionByPosition(workProperty);
        return this.createLineImg(map, "岗位", "薪资");
    }

    @Override
    public InputStream salaryDistributionByWorkPlace(Integer workProperty) {
        val map = ListHelper.MapSpiltLastGroup(
                adminMapper.salaryDistributionByWorkPlace(workProperty));

        return this.createLineImg(this.WorkPlaceGroup(map, true),
                "工作地点", "人数");
    }

    @Override
    public InputStream salaryDistributionByCompany(Integer workProperty) {
        val map = adminMapper.salaryDistributionByCompany(workProperty);

        return  this.createLineImg(map, "公司", "薪资");
    }

    @Override
    public InputStream salaryDistributionByCompanyProperty(Integer workProperty) {
        val map = adminMapper.salaryDistributionByCompanyProperty(workProperty);

        return  this.createLineImg(this.EnumGroup(map, EnumType.CompanyProperty),
                "公司", "薪资");
    }
}
