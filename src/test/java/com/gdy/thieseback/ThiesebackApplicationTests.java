package com.gdy.thieseback;

import com.gdy.thieseback.util.AddressHelper;
import com.gdy.thieseback.util.JFreeChartUtil;
import lombok.val;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class ThiesebackApplicationTests {

    @Test
    void contextLoads() {
        AddressHelper addressHelper = new AddressHelper("广东省广州市花都区新华街新都大道68号馨庭花园");
        System.out.println(addressHelper.getProvince());
        System.out.println(addressHelper.getPlace());
    }

    @Test
    void pieImgTest(){
        DefaultPieDataset pds = new DefaultPieDataset();
        pds.setValue("00点-04点", 100);
        pds.setValue("04点-08点", 200);
        pds.setValue("08点-12点", 300);
        pds.setValue("12点-16点", 400);
        pds.setValue("16点-20点", 500);
        pds.setValue("20点-24点", 600);

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(pds, 600, 300);
        jFreeChartUtil.createPieChart();
        jFreeChartUtil.showImg("E:/BeautyGirl.jpg");
    }

    @Test
    void BarImgShow(){
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.setValue(10, "ibm", "2018-05-21");
        ds.setValue(20, "ibm", "2018-05-22");
        ds.setValue(32, "ibm", "2018-05-23");
        ds.setValue(25, "ibm", "2018-05-24");
        ds.setValue(0, "ibm", "2018-05-25");
        ds.setValue(4, "ibm", "2018-05-26");
        ds.setValue(32, "ibm", "2018-05-27");
        ds.setValue(0, "ibm", "2018-05-28");
        ds.setValue(35, "ibm", "2018-05-29");
        ds.setValue(4, "ibm", "2018-05-30");
        ds.setValue(20, "wcc", "2018-05-21");
        ds.setValue(32, "wcc", "2018-05-22");
        ds.setValue(25, "wcc", "2018-05-23");
        ds.setValue(0, "wcc", "2018-05-24");
        ds.setValue(4, "wcc", "2018-05-25");
        ds.setValue(32, "wcc", "2018-05-26");
        ds.setValue(0, "wcc", "2018-05-27");
        ds.setValue(35, "wcc", "2018-05-28");
        ds.setValue(4, "wcc", "2018-05-29");
        ds.setValue(10, "wcc", "2018-05-30");

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(ds, 600, 300, "人数", "时间");
        jFreeChartUtil.createLineChart();
        jFreeChartUtil.showImg("E:/BeautyGirl.jpg");
    }

    @Test
    void LineImgShow(){
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        ds.setValue(10, "ibm", "2018-05-21");
        ds.setValue(20, "ibm", "2018-05-22");
        ds.setValue(32, "wcc", "2018-05-23");
        ds.setValue(25, "ibm", "2018-05-24");
        ds.setValue(0, "ibm", "2018-05-25");
        ds.setValue(4, "ibm", "2018-05-26");
        ds.setValue(32, "ibm", "2018-05-27");
        ds.setValue(0, "ibm", "2018-05-28");
        ds.setValue(35, "ibm", "2018-05-29");
        ds.setValue(4, "ibm", "2018-05-30");

        JFreeChartUtil jFreeChartUtil = new JFreeChartUtil(ds, 600, 300, "人数", "时间");
        jFreeChartUtil.createBarChart();
        jFreeChartUtil.showImg("E:/BeautyGirl.jpg");
    }

}
