package com.itw.configProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@ConfigurationProperties(prefix = "myapp.weather")
@Validated
public class WeatherProperties {
	@NotNull
	String urlStr;
	@NotNull
    String appKey;
}
