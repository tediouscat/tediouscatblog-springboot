package com.tediouscat.tediouscatblog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.tediouscat.tediouscatblog.common.domain.mapper")
public class MybatisPlusConfig {
}