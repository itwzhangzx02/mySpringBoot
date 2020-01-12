package com.itw.learn.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Configuration
//@MapperScan(basePackages = "com.itw.learn.dao", sqlSessionFactoryRef = "SqlSessionFactory") //basePackages 我们接口文件的地址
public class DynamicDataSourceConfig implements EnvironmentAware {

	private Environment env;
    //由于我使用的是yml文件的方式，在DataSourceBuilder中的properties属性没有赋值
	//需要手动赋值
	// 将这个对象放入Spring容器中
	//@Bean(name = "PrimaryDataSource")
	// 表示这个数据源是默认数据源
	public DataSource getDateSource1() {
		return DataSourceBuilder
				.create()
				.driverClassName(env.getProperty("spring.datasource.primary.driver-class-name"))
				.url(env.getProperty("spring.datasource.primary.url"))
				.username( env.getProperty("spring.datasource.primary.username"))
				.password(env.getProperty("spring.datasource.primary.password"))
				.build();
	}


	//@Bean(name = "SecondaryDataSource")
	public DataSource getDateSource2() {
		return DataSourceBuilder
				.create()
				.driverClassName(env.getProperty("spring.datasource.slave1.driver-class-name"))
				.url(env.getProperty("spring.datasource.slave1.url"))
				.username( env.getProperty("spring.datasource.slave1.username"))
				.password(env.getProperty("spring.datasource.slave1.password"))
				.build();
	}

	//@Bean(name = "dynamicDataSource")
	public DynamicDataSource DataSource(@Qualifier("PrimaryDataSource") DataSource primaryDataSource,
										@Qualifier("SecondaryDataSource") DataSource secondaryDataSource) {

		//这个地方是比较核心的targetDataSource 集合是我们数据库和名字之间的映射
		Map<Object, Object> targetDataSource = new HashMap<>();
		targetDataSource.put("primary", primaryDataSource);
		targetDataSource.put("slave1", secondaryDataSource);
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSource);
		dataSource.setDefaultTargetDataSource(primaryDataSource);//设置默认对象
		return dataSource;
	}


	//@Bean(name = "SqlSessionFactory")
	public SqlSessionFactory SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dynamicDataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver()
						.getResources("classpath*:mapping/*/*.xml"));//设置我们的xml文件路径
		return bean.getObject();
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment ;
	}
}