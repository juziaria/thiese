package com.gdy.thieseback.dto;

import com.gdy.graduate.entity.Recruitment;
import com.gdy.graduate.entity.Requirement;
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

    private Requirement requirement;

    private HashMap<String, String> company;
}
