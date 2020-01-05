package com.itw.service;


import com.itw.configProperties.WeatherProperties;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
	@Autowired
	private RestTemplate restTemplate;

	public WeatherService(WeatherProperties weatherProperties) {
		this.appKey = weatherProperties.getAppKey();
		this.urlStr = weatherProperties.getUrlStr();
	}

	private String urlStr;

	private String appKey;

	public String getWeatherInfo(String  city){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("appkey", appKey);
		jsonObject.put("city", city);
		String json = JSONObject.toJSONString(jsonObject);
		//使用restTemplate进行访问远程Http服务
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
		//这个接口的appkey不能放到请求体中，所以需要修改逻辑
		String result = restTemplate.postForObject(urlStr, httpEntity, String.class);
		return result;
	}

}
