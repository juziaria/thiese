package com.gdy.thieseback.util;

import com.gdy.thieseback.entity.Parameter;
import org.apache.poi.ss.formula.functions.T;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminToolHelper {

    public static String setSize(long size) {
        int GB = 1024 * 1024 * 1024;//定义GB的计算常量
        int MB = 1024 * 1024;//定义MB的计算常量
        int KB = 1024;//定义KB的计算常量
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String resultSize = "";
        if (size / GB >= 1) {
            //如果当前Byte的值大于等于1GB
            resultSize = df.format(size / (float) GB) + "GB   ";
        } else if (size / MB >= 1) {
            //如果当前Byte的值大于等于1MB
            resultSize = df.format(size / (float) MB) + "MB   ";
        } else if (size / KB >= 1) {
            //如果当前Byte的值大于等于1KB
            resultSize = df.format(size / (float) KB) + "KB   ";
        } else {
            resultSize = size + "B   ";
        }

        return resultSize;
    }

    public static Date StringToDate(String dateStr) {
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Parameter.DatePattern);
        try {
            if (dateStr != null && !dateStr.equals("")) {
                date = simpleDateFormat.parse(dateStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String DateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Parameter.DatePattern);
        return simpleDateFormat.format(date);
    }

}