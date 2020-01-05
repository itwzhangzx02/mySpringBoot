package com.itwzhangzx.boot.controller;

import com.itwzhangzx.boot.config.MailModuleProperties;
import com.itwzhangzx.boot.config.RandomModuleProperties;
import com.itwzhangzx.boot.constant.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MailController {

	@Autowired
	private MailModuleProperties mailModuleProperties ;

	@RequestMapping("/getMailModuleProperties")
	public  String getMailModuleProperties(){
		System.out.println(mailModuleProperties);
		return mailModuleProperties.toString() ;
	}

	@RequestMapping("/getRandomModuleProperties")
	public  String getRandomModuleProperties(){
		Binder binder =Binder.get(SpringContextUtils.getApplicationContext().getEnvironment());
		String name = binder.bind("myapp.mail.name",String.class)
		.get();
		System.out.println(binder.bind("myapp.mail.name", String.class).map(String::toUpperCase).get());
		String stringValue = binder.bind("com.itw.boot",
				Bindable.of(RandomModuleProperties.class))
				.get().getStringValue();
		binder.bind("myapp.mail.servers",Bindable.listOf(String.class))
				.get()
				.stream()
		        .forEach(System.out::println);
		Map map = binder.bind("com.itw.boot",Bindable.mapOf(String.class,Object.class))
				.get();
		System.out.println(map.get("stringValue"));
		System.out.println(binder.bind("zzx.hhh.www", String.class)
				.orElseGet(() -> "345"));
		System.out.println(name);
		return stringValue ;
	}


}
