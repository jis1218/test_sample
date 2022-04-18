package com.insup.testsample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = TestsampleApplication.class)
@SpringBootApplication
public class TestsampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsampleApplication.class, args);
	}

}
