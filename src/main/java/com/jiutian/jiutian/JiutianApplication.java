package com.jiutian.jiutian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@MapperScan("com.jiutian.jiutian.mapper")
public class JiutianApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiutianApplication.class, args);
    }

}
