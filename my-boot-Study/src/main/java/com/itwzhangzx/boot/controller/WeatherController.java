package com.itwzhangzx.boot.controller;

import com.itw.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping("/getWeatherByCity")
	public  String getWeatherByCity(HttpServletRequest request){
		return weatherService.getWeatherInfo(request.getParameter("city"));
	}


}
