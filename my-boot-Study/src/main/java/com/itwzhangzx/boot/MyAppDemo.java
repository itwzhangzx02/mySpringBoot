package com.itwzhangzx.boot;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// 测试通用Mapper插件的时候，只要把MapperScan注解改成插件自己的就可以了
//同时我们用的h2数据库，使用配置文件application-h2datasource.yml
//测试类用的是SimpleTest
@MapperScan("com.itwzhangzx.boot.dao")
@SpringBootApplication
public class MyAppDemo {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(MyAppDemo.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		// 目的是
		return args -> {
			System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
			String[] beanNames = ctx.getBeanDefinitionNames();
			//Arrays.sort(beanNames);
			//Arrays.stream(beanNames).forEach(System.out::println);
		};
	}
}
