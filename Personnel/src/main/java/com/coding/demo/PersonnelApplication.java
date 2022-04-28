package com.coding.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
@MapperScan(basePackages="com.coding.demo.mapper")
@SpringBootApplication
public class PersonnelApplication {
	public static void main(String[] args) {
		SpringApplication.run(PersonnelApplication.class, args);
	}
}
