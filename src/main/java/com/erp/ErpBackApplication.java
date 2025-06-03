package com.erp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper接口
@MapperScan("com.erp.mapper")
public class ErpBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpBackApplication.class, args);
    }

}
