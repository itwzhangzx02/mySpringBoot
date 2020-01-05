package com.itwzhangzx.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 加一个@Component注解，将这个bean让Spring管理起来
 *
 * @ConfigurationProperties注解比@value注解功能更强大，但是不能使用 SPel表达式
 * @Validated注解用于参数校验 JSR-303
 */

@Component
@ConfigurationProperties(prefix = "com.itw.boot")
@Data
public class RandomModuleProperties {

   Long Bignumber;

   int  intnumber;

   String stringValue ;



}
