package com.gdy.thieseback.entity;


import kotlin.OverloadResolutionByLambdaReturnType;
import org.springframework.beans.factory.annotation.Autowired;

public enum GenderEnum {
    MAN(0,"男"),
    WOMAN(1,"女"),
    NOLL(2,"不知道"),
    ;

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    private int code;
    private String content;

    GenderEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static GenderEnum find(int code) {
        for (GenderEnum value : GenderEnum.values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static GenderEnum find(String content) {
        for (GenderEnum value : GenderEnum.values()) {
            if(content == value.content){
                return value;
            }
        }

        return null;
    }
}
