package com.gdy.thieseback.entity;

import org.springframework.beans.factory.annotation.Autowired;

public enum MeetingTypeEnum {
    DoubleChoiceMeeting(0,"双选会"),
    TeachIn(1,"宣讲会"),
    NOLL(2,"暂定"),
    ;

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    private int code;
    private String content;

    MeetingTypeEnum(int code, String content){
        this.code = code;
        this.content = content;
    }

    public static MeetingTypeEnum find(int code) {
        for (MeetingTypeEnum value : MeetingTypeEnum.values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static MeetingTypeEnum find(String content) {
        for (MeetingTypeEnum value : MeetingTypeEnum.values()) {
            if(content == value.content){
                return value;
            }
        }

        return null;
    }
}
