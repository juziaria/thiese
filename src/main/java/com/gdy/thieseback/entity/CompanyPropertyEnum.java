package com.gdy.thieseback.entity;

import org.springframework.beans.factory.annotation.Autowired;

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



    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    private int code;
    private String content;

    CompanyPropertyEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static CompanyPropertyEnum find(int code) {
        for (CompanyPropertyEnum value : CompanyPropertyEnum.values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static CompanyPropertyEnum find(String content) {
        for (CompanyPropertyEnum value : CompanyPropertyEnum.values()) {
            if(content == value.content){
                return value;
            }
        }

        return null;
    }
}
