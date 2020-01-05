package com.itw.autoConfig;

import com.itw.configProperties.WeatherProperties;
import com.itw.service.WeatherService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(WeatherProperties.class)
public class AutoConfigWeatherProperties {

	public AutoConfigWeatherProperties(){
		System.out.println("starter:AutoConfigWeatherProperties");
	}

	@Bean
	public RestTemplate getRestTemplate (){
		return new RestTemplate();
	}

	@Bean
	public WeatherService getWeatherService(WeatherProperties weatherProperties){
		return new WeatherService(weatherProperties);
	}



}
