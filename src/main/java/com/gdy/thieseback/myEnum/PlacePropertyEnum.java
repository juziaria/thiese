package com.gdy.thieseback.myEnum;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

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
        for (PlacePropertyEnum value : values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static PlacePropertyEnum find(String content) {
        for (PlacePropertyEnum value : values()) {
            if(Objects.equals(content, value.content)){
                return value;
            }
        }

        return null;
    }
}
