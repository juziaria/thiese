package com.gdy.thieseback.util;


import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class JFreeChartUtil {
    public InputStream imgStream;

    private String xLabel;
    private String yLabel;
    private int width;
    private int height;

    private DefaultPieDataset pds;      //饼图
    private DefaultCategoryDataset ds;  //折线图、条形图

    public JFreeChartUtil(){}

    public JFreeChartUtil(int width, int height, String xLabel, String yLabel){
        this.width = width;
        this.height = height;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
    }

    public JFreeChartUtil(DefaultPieDataset pds, int width, int height) {
        this(width, height, null, null);
        this.pds = pds;
    }

    public JFreeChartUtil(DefaultCategoryDataset ds, int width, int height, String xLabel, String yLabel) {
        this(width, height, xLabel, yLabel);
        this.ds = ds;
    }

    //饼图
    /*  DefaultPieDataset pds = new DefaultPieDataset();
        pds.setValue("00点-04点", 100);
        pds.setValue("04点-08点", 200);
        pds.setValue("08点-12点", 300);
        pds.setValue("12点-16点", 400);
        pds.setValue("16点-20点", 500);
        pds.setValue("20点-24点", 600);*/
    public void createPieChart() {
        try {
            // 分别是:显示图表的标题、需要提供对应图表的DateSet对象、是否显示图例、是否生成贴士以及是否生成URL链接
            JFreeChart chart = ChartFactory.createPieChart("", this.pds, false, false, true);
            // 如果不使用Font,中文将显示不出来
            Font font = new Font("宋体", Font.BOLD, 12);
            // 设置图片标题的字体
            chart.getTitle().setFont(font);
            // 得到图块,准备设置标签的字体
            PiePlot plot = (PiePlot) chart.getPlot();
            // 设置标签字体
            plot.setLabelFont(font);
            plot.setStartAngle(new Float(3.14f / 2f));
            // 设置plot的前景色透明度
            plot.setForegroundAlpha(0.7f);
            // 设置plot的背景色透明度
            plot.setBackgroundAlpha(0.0f);
            // 设置标签生成器(默认{0})
            // {0}:key {1}:value {2}:百分比 {3}:sum
            plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}({1}占{2})"));

            this.JFreeChartToStream(chart, this.width, this.height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //折线图
    /*  DefaultCategoryDataset ds = new DefaultCategoryDataset();
		ds.setValue(10, "ibm", "2018-05-21");
        ds.setValue(20, "ibm", "2018-05-22");
        ds.setValue(32, "ibm", "2018-05-23");
        ds.setValue(25, "ibm", "2018-05-24");
        ds.setValue(0, "ibm", "2018-05-25");
        ds.setValue(4, "ibm", "2018-05-26");
        ds.setValue(32, "ibm", "2018-05-27");
        ds.setValue(0, "ibm", "2018-05-28");
        ds.setValue(358, "ibm", "2018-05-29");
        ds.setValue(4, "ibm", "2018-05-30");*/
    public void createLineChart() {
        try {
            // 标题,X坐标,Y坐标,数据集合,orientation,是否显示legend,是否显示tooltip,是否使用url链接
            JFreeChart chart = ChartFactory.createLineChart("", this.xLabel,
                    this.yLabel, this.ds, PlotOrientation.VERTICAL,false, true, true);
            chart.setBackgroundPaint(Color.WHITE);
            Font font = new Font("宋体", Font.BOLD, 12);
            chart.getTitle().setFont(font);
            chart.setBackgroundPaint(Color.WHITE);
            // 配置字体（解决中文乱码的通用方法）
            Font xfont = new Font("仿宋", Font.BOLD, 12); // X轴
            Font yfont = new Font("宋体", Font.BOLD, 12); // Y轴
            Font titleFont = new Font("宋体", Font.BOLD, 12); // 图片标题
            CategoryPlot categoryPlot = chart.getCategoryPlot();
            categoryPlot.getDomainAxis().setLabelFont(xfont);
            categoryPlot.getDomainAxis().setLabelFont(xfont);
            categoryPlot.getRangeAxis().setLabelFont(yfont);
            chart.getTitle().setFont(titleFont);
            categoryPlot.setBackgroundPaint(Color.WHITE);
            // x轴 // 分类轴网格是否可见
            categoryPlot.setDomainGridlinesVisible(true);
            // y轴 //数据轴网格是否可见
            categoryPlot.setRangeGridlinesVisible(true);
            // 设置网格竖线颜色
            categoryPlot.setDomainGridlinePaint(Color.LIGHT_GRAY);
            // 设置网格横线颜色
            categoryPlot.setRangeGridlinePaint(Color.LIGHT_GRAY);
            // 没有数据时显示的文字说明
            categoryPlot.setNoDataMessage("没有数据显示");
            // 设置曲线图与xy轴的距离
            categoryPlot.setAxisOffset(new RectangleInsets(0d, 0d, 0d, 0d));
            // 设置面板字体
            Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
            // 取得Y轴
            NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            rangeAxis.setAutoRangeIncludesZero(true);
            rangeAxis.setUpperMargin(0.20);
            rangeAxis.setLabelAngle(Math.PI / 2.0);
            // 取得X轴
            CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
            // 设置X轴坐标上的文字
            categoryAxis.setTickLabelFont(labelFont);
            // 设置X轴的标题文字
            categoryAxis.setLabelFont(labelFont);
            // 横轴上的 Lable 45度倾斜
            categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
            // 设置距离图片左端距离
            categoryAxis.setLowerMargin(0.0);
            // 设置距离图片右端距离
            categoryAxis.setUpperMargin(0.0);
            // 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
            LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
            // 是否显示折点
            lineandshaperenderer.setBaseShapesVisible(true);
            // 是否显示折线
            lineandshaperenderer.setBaseLinesVisible(true);
            // series 点（即数据点）间有连线可见 显示折点数据
            lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            lineandshaperenderer.setBaseItemLabelsVisible(true);

            this.JFreeChartToStream(chart, this.width, this.height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //条形图
    /*  dataset.addValue(1.0, "A", "Ⅰ");
        dataset.addValue(3.0, "A", "Ⅱ");
        dataset.addValue(5.0, "A", "Ⅲ");
        dataset.addValue(5.0, "A", "Ⅳ");
        dataset.addValue(5.0, "B", "Ⅰ");
        dataset.addValue(6.0, "B", "Ⅱ");
        dataset.addValue(10.0, "B", "Ⅲ");
        dataset.addValue(4.0, "B", "Ⅳ");*/
    public void createBarChart(){
        JFreeChart chart = ChartFactory.createBarChart3D("", this.xLabel, this.yLabel, this.ds,
                PlotOrientation.VERTICAL, true, true, false);

        this.JFreeChartToStream(chart, this.width, this.height);
    }


    private void JFreeChartToStream(JFreeChart chart, int width, int height){
        if(chart != null){
            BufferedImage image = chart.createBufferedImage(width, height, 1, null);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            try {
                ImageIO.write(image, "jpg", stream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.imgStream = new ByteArrayInputStream(stream.toByteArray());
        }
    }

}
