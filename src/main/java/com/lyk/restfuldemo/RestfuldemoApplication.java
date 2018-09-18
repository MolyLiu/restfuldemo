package com.lyk.restfuldemo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class RestfuldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfuldemoApplication.class, args);
        System.out.println("程序正在运行……");
    }
}
