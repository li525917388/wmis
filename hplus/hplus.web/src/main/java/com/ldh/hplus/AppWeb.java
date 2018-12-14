package com.ldh.hplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @author Li Dehuan
 * @date 2018年12月14日
 *
 */
@MapperScan(basePackages={"com.ldh.hplus.*.dao"})
@SpringBootApplication
public class AppWeb extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		
		SpringApplication.run(AppWeb.class, args);
	}

	@Override//为了打包springboot项目 
	protected SpringApplicationBuilder configure( 
		SpringApplicationBuilder builder) { 
		return builder.sources(this.getClass()); 
	} 
	
}
