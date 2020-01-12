package com.itw.learn.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DynamicDataSourceRegister implements  ImportBeanDefinitionRegistrar,EnvironmentAware , ResourceLoaderAware {

	private Environment environment;

	private ResourceLoader resourceLoader;

	//默认数据源
	private DataSource defaultDataSource;
	//所有的数据源
	private Map<String, DataSource> targetDataSources = new HashMap<>();

	void initDefaultDataSource(){
		defaultDataSource = DataSourceBuilder
				.create()
				.driverClassName(environment.getProperty("spring.datasource.primary.driver-class-name"))
				.url(environment.getProperty("spring.datasource.primary.url"))
				.username( environment.getProperty("spring.datasource.primary.username"))
				.password(environment.getProperty("spring.datasource.primary.password"))
				.build();
	}

	void initTargetDataSources() {
		// 读取配置文件获取更多数据源
		String dsPrefixs = environment.getProperty("spring.datasource.names");
		for (String dsPrefix : dsPrefixs.split(",")) {
			// 多个数据源
			DataSource ds =DataSourceBuilder
					.create()
					.driverClassName(environment.getProperty("spring.datasource." + dsPrefix + ".driver-class-name"))
					.url(environment.getProperty("spring.datasource." + dsPrefix + ".url"))
					.username( environment.getProperty("spring.datasource." + dsPrefix + ".username"))
					.password(environment.getProperty("spring.datasource." + dsPrefix + ".password"))
					.build();
			targetDataSources.put(dsPrefix,ds);
		}
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
		initDefaultDataSource();
		initTargetDataSources();
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
		//创建DynamicDataSource
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(DynamicDataSource.class);
		beanDefinition.setSynthetic(true);
		MutablePropertyValues mpv = beanDefinition.getPropertyValues();
		mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
		mpv.addPropertyValue("targetDataSources", targetDataSources);
		//注册 - BeanDefinitionRegistry
		beanDefinitionRegistry.registerBeanDefinition("dataSource", beanDefinition);
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

}
