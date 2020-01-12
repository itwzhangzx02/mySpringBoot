package com.itw.learn.config;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDatasource {

   String value() default "primary";

}
