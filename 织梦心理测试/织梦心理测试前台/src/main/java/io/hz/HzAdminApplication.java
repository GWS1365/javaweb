package io.hz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * 项目启动,入口方法
 *
 * @SpringBootApplication注解是Spring Boot的核心注解，组合注解，自动配置
 */
@SpringBootApplication
@MapperScan(basePackages = {"io.hz.modules.*.dao"})  //dao包路径
public class HzAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzAdminApplication.class, args);
    }

}
