package com.avistar.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//扫描mybatis哪些包里面的接口
@MapperScan("com.avistar.contentcenter.dao")
@SpringBootApplication
public class ContentCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class, args);
    }

}
