package com.gdy.thieseback.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;


public class ExcelUtil {


    /**
     * 根据模板导出excel(头部使用模板不多加处理版)
     *
     * @param response
     * @param data         数据集合
     * @param templateName 模板文件
     * @param fileName     输出的文件名
     * @param passRows     跳过头几行
     */
    public static void exportExcelByTemplate(List<LinkedHashMap<String, Object>> data, String templateName, String fileName, int passRows, HttpServletResponse response) {

        ExcelWriter writer = null;
        File newFile = null;
        try {
            if (CollUtil.isNotEmpty(data)) {

                //根据输入流创建新文件对象
                ClassPathResource classPathResource = new ClassPathResource("templates" + File.separator + templateName);
                newFile = FileUtil.writeFromStream(classPathResource.getInputStream(), new File(templateName));
                // 通过工具类创建writer
                writer = cn.hutool.poi.excel.ExcelUtil.getWriter(newFile);
                //设置单元格样式
//                StyleSet style = writer.getStyleSet();
//                CellStyle cellStyle = style.getCellStyle();
//                cellStyle.setWrapText(true); //文本自动换行
                //设置内容字体
//                Font font = writer.createFont();
//                font.setBold(true);  //粗体
//                cellStyle.setFont(font);

                //设置列宽
                writer.setColumnWidth(-1, 20);
                //跳过头几行
                writer.passRows(passRows);

                // 一次性写出内容，使用默认样式
                writer.write(data);

                response.reset();
                response.setContentType("application/vnd.ms-excel;charset=utf-8");
                //处理文件名中文乱码问题
                String name = new String(fileName.getBytes(), "iso8859-1") + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm") + ".xlsx";
                response.setHeader("Content-Disposition", "attachment;filename=" + name);

                writer.flush(response.getOutputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭writer，释放内存
            if (null != writer) {
                writer.close();
            }
            try {
                if (null != newFile) {
                    newFile.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 通用导出
     * @param data
     * @param clazz
     * @param fileName
     * @param response
     */
    public static void export(List data, Class<?> clazz, String fileName, HttpServletResponse response) {

        com.alibaba.excel.ExcelWriter excelWriter = null;
        try {
            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

            // 这里 指定文件
            excelWriter = EasyExcel.write(response.getOutputStream()).build();
            WriteSheet writeSheet = null;
            //
            writeSheet = EasyExcel.writerSheet(0, fileName).head(clazz).build();
            excelWriter.write(data, writeSheet);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
}
