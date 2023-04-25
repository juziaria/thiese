package com.gdy.thieseback.myEnum;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public enum FlagEnum {
    //用户信息、文件、简历
    Upload(0,"已上传"),
    Delete(1,"已删除"),

    // 通知
    Publish(2,"已发布"),
    NotPublish(3,"未发布"),
    //Delete 删除

    //招聘信息
    //Publish 已发布
    Audit(4,"待审核"),
    Reject(5,"已驳回"),
    End(6,"已结束"),

    //会议
    NotStarted(7,"未开始"),
    InProgress(8,"进行中"),
    //End 已结束
    //Delete 删除

    //教室
    //Delete 已删除
    NotUsed(9,"未使用"),
    Using(10,"使用中"),
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
