package com.gdy.thieseback.util;

import lombok.Data;

import java.io.UnsupportedEncodingException;

@Data
public class PathHelper {
    private String path;

    public String getPath() {
        try {
            return java.net.URLDecoder.decode(this.path, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public PathHelper(){}

    public PathHelper(String path){
        this.path = path.replace("\\\\","/");
    }

    public PathHelper(String dirPath, String fileName, String extension){
        String path = String.format("%s\\\\%s.%s", dirPath, fileName, extension);
        this.path = path.replace("\\\\","/");
    }
}
