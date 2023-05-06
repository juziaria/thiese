package com.gdy.thieseback.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_file")
public class Files {
    //@TableId(type = IdType.AUTO)
    private Integer id; //主键
    private String name;//文件名
    private String type;//类型
    private Long size;//大小
    private String url;//路径
    private String md5; //确认文件唯一
    private Boolean isDelete; //是否删除
    private Boolean enable; //是否可用
}
