package com.gdy.thieseback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gdy.thieseback.mapper")
public class ThiesebackApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThiesebackApplication.class, args);
    }

}
