package com.ckai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ckai.vehicle.mapper")
@EnableScheduling
public class MiBmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiBmsApplication.class, args);
    }

}
