package com.gdy.thieseback.myEnum;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public enum NoticeTypeEnum {
    TripartiteAgreement(0,"三方协议"),
    EmploymentInfofilling(1,"就业信息填报"),
    Instructors(2,"实习指导"),
    EmploymentPolicy(3,"就业政策"),
    Other(4,"其他通知"),
    ;

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    private int code;
    private String content;

    NoticeTypeEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static NoticeTypeEnum find(int code) {
        for (val value : values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static NoticeTypeEnum find(String content) {
        for (val value : values()) {
            if(Objects.equals(content, value.content)){
                return value;
            }
        }

        return null;
    }
}
