package com.gdy.thieseback.dto;

import lombok.Data;

import java.util.HashMap;

@Data
public class MeetingInfo {
    private Integer id;

    private String name;

    private String place;

    private String master;

    private Integer amount;

    private String major;

    private String type;

    private String time;
}
