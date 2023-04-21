package com.gdy.thieseback.entity;

import javax.swing.filechooser.FileSystemView;

public class Parameter {
    public static Integer NumPerPager;

    public static String InitPwd;

    public static String DatePattern;

    public static String splitChar;

    public static Boolean isOpenQuestionnaire;

    public static String defaultSavePath;

    public Parameter(){
        NumPerPager = 20;
        InitPwd = "123456";
        DatePattern = "yyyy-MM-dd";
        splitChar = ";";
        isOpenQuestionnaire = false;
        defaultSavePath = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
    }
}
