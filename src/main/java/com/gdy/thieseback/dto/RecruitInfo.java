package com.gdy.thieseback.dto;

import com.gdy.thieseback.entity.Requirement;
import lombok.Data;

import java.util.HashMap;

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
