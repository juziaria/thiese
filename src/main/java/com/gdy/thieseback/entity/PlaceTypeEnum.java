package com.gdy.thieseback.entity;

import org.springframework.beans.factory.annotation.Autowired;

public enum PlaceTypeEnum {
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

    PlaceTypeEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static PlaceTypeEnum find(int code) {
        for (PlaceTypeEnum value : PlaceTypeEnum.values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static PlaceTypeEnum find(String content) {
        for (PlaceTypeEnum value : PlaceTypeEnum.values()) {
            if(content == value.content){
                return value;
            }
        }

        return null;
    }
}
