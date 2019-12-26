package com.itwzhangzx.boot.controller;

import com.itwzhangzx.boot.utils.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class HelloWorld {

	@RequestMapping("/HELLO")
	String getMess(){
		return  "hello world " ;
	}

    /**
	 * /weather?city=taiyuan
	 * */
	@RequestMapping("/weather")
	String getWeatherMess(HttpServletRequest request) throws Exception {
		String urlStr ="http://way.jd.com/he/freeweather";
		HashMap<String,String> params = new HashMap<String ,String>();
		params.put("city",request.getParameter("city"));
		params.put("appkey",request.getParameter("appkey"));
		return HttpUtil.getMessageByPost(urlStr,params);
	}

	/**
	 * http://localhost:8080/usrStr?
	 * usrStr=http://way.jd.com/he/freeweather
	 * &city=beijing
	 * &appkey=b2e140b9a7de443fd191b865ad7324d7
	 * */
	@RequestMapping("/usrStr")
	String getThridMess(HttpServletRequest request,
						@RequestParam HashMap<String,String> params) throws Exception {
		String urlStr =request.getParameter("usrStr");
		params.remove("usrStr");
		return HttpUtil.getMessageByPost(urlStr,params);
	}

}
