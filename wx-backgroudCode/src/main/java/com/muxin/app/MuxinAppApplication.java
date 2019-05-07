package com.muxin.app;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@MapperScan(basePackages = "com.muxin.app.dao.mapper")
@SpringBootApplication
public class MuxinAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuxinAppApplication.class, args);
    }

}
