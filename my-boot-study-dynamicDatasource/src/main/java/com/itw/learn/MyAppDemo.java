package com.itw.learn;

import com.itw.learn.config.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


import java.util.Arrays;


@MapperScan("com.itw.learn.dao")
@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
public class MyAppDemo {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(MyAppDemo.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		// 目的是
		return args -> {
			System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.stream(beanNames)
					.filter(t->t.equals("PrimaryDatasource"))
					.forEach(System.out::println);
			//Arrays.sort(beanNames);
			//Arrays.stream(beanNames).forEach(System.out::println);
		};
	}
}
