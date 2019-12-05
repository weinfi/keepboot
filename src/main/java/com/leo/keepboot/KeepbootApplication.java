package com.leo.keepboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@ServletComponentScan
public class KeepbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(KeepbootApplication.class, args);
	}
}
