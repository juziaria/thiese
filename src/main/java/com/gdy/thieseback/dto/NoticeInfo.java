package com.gdy.thieseback.dto;

import io.swagger.annotations.ApiModelProperty;
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

}
