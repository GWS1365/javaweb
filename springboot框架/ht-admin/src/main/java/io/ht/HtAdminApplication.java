package io.ht;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"io.ht.modules.*.dao"})  //dao包路径
public class HtAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtAdminApplication.class, args);
	}

}
