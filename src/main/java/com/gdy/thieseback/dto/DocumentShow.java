package com.gdy.thieseback.dto;

import java.util.ArrayList;
import java.util.List;

public class DocumentShow {
    public Integer count;
    public List<DocumentInfo> documentInfoList;

    public DocumentShow(){
        this.count = 0;
        this.documentInfoList = new ArrayList<>();
    }
}


