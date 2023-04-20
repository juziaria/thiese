package com.gdy.thieseback.dto;

import java.util.ArrayList;
import java.util.List;

public class DocumentShowDto {
    public Integer count;
    public List<DocumentInfoDto> documentInfoList;

    public DocumentShowDto(){
        this.count = 0;
        this.documentInfoList = new ArrayList<>();
    }
}


