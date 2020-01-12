package com.itw.learn.config;

public class DataSourceContextHandler {

	private static final ThreadLocal<String> context = new ThreadLocal();
    //为了保证 A()-->B()-->C()-->D() 这样的方法调用链中，
	//只要调用者已设置数据源类型，则被调用者不能再设置数据源类型。
	//比如 写操作方法中调用读操作方法，读操作方法调用写操作方法
	//一直切换的化，事务会出问题。
	public static  void setDataSourceType(String type){
		if(context.get()==null)
		   context.set(type);
	}

	public static Object getDataSourceType() {
		//给默认值，如果取出来为null，则走主库,可以抽取到配置信息中，从配置文件查
		return context.get()==null ? "primary" : context.get();
	}

	public static void clearDataSourceType(){
		context.remove();
	}
}
