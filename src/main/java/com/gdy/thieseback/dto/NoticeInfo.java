package com.gdy.thieseback.dto;

import lombok.Data;

import java.util.HashMap;


@Data
public class NoticeInfo {
    private int id;

    private String publishTime;

    private String collage;

    private String title;

    private String content;

    private HashMap<Integer, String> document;

    private Integer type;

}
