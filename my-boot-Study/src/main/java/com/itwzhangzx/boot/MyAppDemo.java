package com.itwzhangzx.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.*;

import org.springframework.context.ApplicationContext;
@MapperScan("com.itwzhangzx.boot.dao")
@SpringBootApplication
public class MyAppDemo {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(MyAppDemo.class, args);

	}
}
