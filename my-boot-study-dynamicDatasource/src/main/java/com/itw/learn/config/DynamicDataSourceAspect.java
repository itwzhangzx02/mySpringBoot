package com.itw.learn.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {

	@Before("@annotation(dataSource)")
	public void setTargetDatasource(JoinPoint point, TargetDatasource dataSource){
		String value = dataSource.value();
		if ("primary".equals(value)){
			DataSourceContextHandler.setDataSourceType("primary");
		}else if ("slave1".equals(value)){
			DataSourceContextHandler.setDataSourceType("slave1");
		}else {
			DataSourceContextHandler.setDataSourceType("primary");
		}
	}

	/**
	 * 重置数据源
	 * @param point
	 * @param dataSource
	 */
	@After("@annotation(dataSource))")
	public void restoreDataSource(JoinPoint point, TargetDatasource dataSource) {
		// 将数据源置为默认数据源
		DataSourceContextHandler.clearDataSourceType();
		System.out.println("Restore DataSource to [" + DataSourceContextHandler.getDataSourceType()
				+ "] in Method [" + point.getSignature() + "]");
	}
}
