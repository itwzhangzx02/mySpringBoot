package com.itwzhangzx.boot.controller;
import com.itwzhangzx.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/getUserById")
	public  String getWeatherByCity(HttpServletRequest request){
		return userService.
				selectUser((String)request.getParameter("id")).
				toString();
	}
}
