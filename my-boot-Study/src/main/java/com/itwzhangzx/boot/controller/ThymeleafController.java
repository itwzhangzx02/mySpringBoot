package com.itwzhangzx.boot.controller;

import com.itwzhangzx.boot.pojo.User;
import com.itwzhangzx.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ThymeleafController {

	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request){

		ModelAndView view = new ModelAndView();
		// 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
		view.setViewName("index");
		// 设置属性
		view.addObject("title", "我的第一个THYMELEAF编写的页面");
		view.addObject("desc", "不传参数 id 的时候，返回的时id为10的用户信息");
		System.out.println(request.getParameter("id"));
		String id = Optional.ofNullable(request.getParameter("id")).orElse("10");
		System.out.println(id);
		User user = userService.selectUser(id);
		view.addObject("user",user);
		return view;
	}
}
