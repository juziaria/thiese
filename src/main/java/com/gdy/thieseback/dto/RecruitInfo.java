package com.gdy.thieseback.dto;

import com.gdy.thieseback.entity.Recruit;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;

@Data
public class RecruitInfo {

    private Integer id;

    private String position;

    private String workContent;

    private Integer salary;

    private String workPlace;

    private HashMap<String, String> company;
}
