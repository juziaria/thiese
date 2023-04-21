package com.gdy.thieseback.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class MeetingInfo {
    private Integer id;

    private String name;

    private HashMap<String, String> company;

    private String meetingFormat;

    private HashMap<Integer, String> classroom;

    private Integer amount;

    private String major;

    private String meetingType;

    private String startTime;
}
