package com.gdy.thieseback.until;

import lombok.Data;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.util.UUID;

@Data
public class Encrypt implements Serializable {

    /**
     * 定义一个md5算法的加密处理
     */
    public  String getMD5(String PWD,String salt){
        for(int i = 0; i<3;i++){
            PWD= DigestUtils.md5DigestAsHex((salt+PWD+salt).getBytes()).toUpperCase();
        }
        return PWD;
    }

    private String salt;

    public String getSalt() {
        salt = UUID.randomUUID().toString().toUpperCase();
        return salt;
    }
}
