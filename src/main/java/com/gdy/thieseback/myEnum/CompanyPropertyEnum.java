package com.gdy.thieseback.myEnum;

import lombok.val;

import java.util.Objects;

public enum CompanyPropertyEnum {
    PartyAndGovernmentOffices(0,"党政机关"),
    Universities(1,"高等院校"),
    ResearchInstitutes(2,"科研单位"),
    OtherPublicInstitutions(3,"其他事业单位"),
    StateOwnedEnterprise(4,"国有企业"),
    PrivateEnterprise(5,"民营企业"),
    ForeignEnterprise(6,"外资企业"),
    Army(7,"部队"),
    ;

    CompanyPropertyEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    private int code;
    private String content;

    public Integer getCode(){
        return this.code;
    }

    public String getContent(){
        return this.content;
    }

    public static CompanyPropertyEnum find(int code) {
        for (val value : values()) {
            if(Objects.equals(code, value.code)){
                return value;
            }
        }
        return null;
    }

    public static CompanyPropertyEnum find(String content) {
        for (val value : values()) {
            if(Objects.equals(content, value.content)){
                return value;
            }
        }
        return null;
    }


}
