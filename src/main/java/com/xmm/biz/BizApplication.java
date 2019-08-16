package com.xmm.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(basePackages = "com.xmm.biz.dao")
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class BizApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizApplication.class, args);
    }

}
