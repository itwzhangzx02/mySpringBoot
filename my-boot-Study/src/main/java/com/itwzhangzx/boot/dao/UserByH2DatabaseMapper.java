package com.itwzhangzx.boot.dao;


import com.itwzhangzx.boot.pojo.h2pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserByH2DatabaseMapper extends BaseMapper<User>{
    @Select(value = "select * from user where name = #{vvv} ")
	public  User selectByName(String name);

	public  User selectUser(String jack);
}
