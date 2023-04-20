package com.gdy.thieseback.util;

import lombok.Data;

import java.io.UnsupportedEncodingException;

@Data
public class MyPath {
    private String path;

    public String getPath() {
        try {
            return java.net.URLDecoder.decode(this.path, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public MyPath(){}

    public MyPath(String path){
        path = path.replace("\\\\","/");
        this.path = path;
    }
}
