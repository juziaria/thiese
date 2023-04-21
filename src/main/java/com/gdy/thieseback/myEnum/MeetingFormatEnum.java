package com.gdy.thieseback.myEnum;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public enum MeetingFormatEnum {
    OnLine(0,"线上"),
    OffLine(1,"线下"),
    NULL(2,"暂定"),
    ;

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    private int code;
    private String content;

    MeetingFormatEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static MeetingFormatEnum find(int code) {
        for (MeetingFormatEnum value : values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static MeetingFormatEnum find(String content) {
        for (MeetingFormatEnum value : values()) {
            if(Objects.equals(content, value.content)){
                return value;
            }
        }

        return null;
    }
}
