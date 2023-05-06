package com.gdy.thieseback.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 专业和招聘之间的关系表
 * @TableName stu_reruit_major_relation
 */
@TableName(value = "stu_reruit_major_relation")
@Data
public class StudentRecruitMajorRelation  implements Serializable {
    /**
     * 招聘id
     */
    @TableField(value = "recruit_id")
    private String recruitId;


    /**
     * 专业id
     */
    @TableField(value = "major_id")
    private String majorId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
