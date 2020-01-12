package com.itw.learn.dao;


import com.itw.learn.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {

	//使用注解式的sql注入
	@Select("select * from u_user where usercode = #{简单类型只有一个参数的时候随便写}")
	public  User selectOne(String id);
}
