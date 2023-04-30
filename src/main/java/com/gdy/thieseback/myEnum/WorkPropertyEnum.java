package com.gdy.thieseback.myEnum;

import lombok.val;

import java.util.Objects;

public enum WorkPropertyEnum {
    FullTime(0,"全职"),
    PartTime(1,"兼职"),
    Practice(2,"实习"),
    ;

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    private int code;
    private String content;

    WorkPropertyEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static WorkPropertyEnum find(int code) {
        for (val value : values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    public static WorkPropertyEnum find(String content) {
        for (val value : values()) {
            if(Objects.equals(content, value.content)){
                return value;
            }
        }

        return null;
    }
}
