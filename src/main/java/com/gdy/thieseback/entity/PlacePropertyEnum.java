package com.gdy.thieseback.entity;

import org.springframework.beans.factory.annotation.Autowired;

public enum PlacePropertyEnum {
    Village(0,"农村"),
    City(1,"城镇"),
    ;

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    private int code;
    private String content;

    PlacePropertyEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static PlacePropertyEnum find(int code) {
        for (PlacePropertyEnum value : PlacePropertyEnum.values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static PlacePropertyEnum find(String content) {
        for (PlacePropertyEnum value : PlacePropertyEnum.values()) {
            if(content == value.content){
                return value;
            }
        }

        return null;
    }
}
