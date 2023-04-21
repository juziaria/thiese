package com.gdy.thieseback.myEnum;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public enum FlagEnum {
    Upload(0,"已上传"),//用户信息
    Delete(1,"已删除"),//用户信息、通知
    Publish(2,"已发布"),//通知、招聘信息
    NotPublish(3,"未发布"),//通知
    Audit(4,"待审核"),//招聘信息
    Reject(5,"已驳回"),//招聘信息
    End(6,"已结束"),//招聘信息



    ;

    private int code;
    private String content;

    public String getContent() {
        return this.content;
    }

    public int getCode() {
        return this.code;
    }

    FlagEnum(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public static FlagEnum find(int code) {
        for (FlagEnum value : values()) {
            if(code == value.code){
                return value;
            }
        }

        return null;
    }

    @Autowired
    public static FlagEnum find(String content) {
        for (FlagEnum value : values()) {
            if(Objects.equals(content, value.content)){
                return value;
            }
        }

        return null;
    }

}
