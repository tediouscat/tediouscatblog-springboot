package com.tediouscat.tediouscatblog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tediouscat.tediouscatblog.*"}) // 多模块项目中，必需手动指定扫描 com.tediouscat.tediouscatblog 包下面的所有类
public class TediouscatblogWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TediouscatblogWebApplication.class, args);
    }

}
