package com.gdy.thieseback.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Setting {
    @ApiModelProperty(value = "一页的数据量")
    private Integer numPerPager;

    @ApiModelProperty(value = "初始化密码")
    private String initPwd;

    @ApiModelProperty(value = "日期格式")
    private String DatePattern;

    @ApiModelProperty(value = "上传的文件保存的路径")
    private String documentSavePath;

    public void setNumPerPager(Integer numPerPager) {
        this.numPerPager = numPerPager;
        Parameter.NumPerPager = numPerPager;
    }
}
