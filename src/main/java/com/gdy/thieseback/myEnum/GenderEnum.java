package com.gdy.thieseback.myEnum;


import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

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
        for (val value : values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static GenderEnum find(String content) {
        for (val value : values()) {
            if(Objects.equals(content, value.content)){
                return value;
            }
        }

        return null;
    }
}
