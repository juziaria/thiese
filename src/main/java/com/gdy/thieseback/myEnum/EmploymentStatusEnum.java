package com.gdy.thieseback.myEnum;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public enum EmploymentStatusEnum {
    Unit_employment(0,"单位就业"),
    Liberal_Profession(1,"自由职业"),
    delayedEmployment(2,"慢就业（暂无打算）"),
    StudyAbroad(3,"留学"),
    DomesticEnrollment(4,"国内升学"),
    Entrepreneurship(5,"创业"),
    ;

    public int getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    private int code;
    private String content;

    EmploymentStatusEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static EmploymentStatusEnum find(int code) {
        for (val value : values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static EmploymentStatusEnum find(String content) {
        for (val value : values()) {
            if(Objects.equals(content, value.content)){
                return value;
            }
        }

        return null;
    }
}
