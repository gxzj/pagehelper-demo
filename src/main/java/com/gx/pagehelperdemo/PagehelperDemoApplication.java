package com.gx.pagehelperdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.gx.pagehelperdemo.mapper") //mapper接口扫描
@EnableTransactionManagement //开启事务管理
public class PagehelperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagehelperDemoApplication.class, args);
    }

}

