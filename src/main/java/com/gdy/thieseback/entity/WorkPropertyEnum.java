package com.gdy.thieseback.entity;

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
}
