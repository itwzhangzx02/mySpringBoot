package com.itwzhangzx.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping("/HELLO")
	String getMess(){
		return  "hello world " ;
	}
}
