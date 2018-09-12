package com.ldh.hplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages={"com.ldh.hplus.*.dao"})
@SpringBootApplication
public class AppWeb {
	
	public static void main(String[] args) {
		
		SpringApplication.run(AppWeb.class, args);
	}

}
