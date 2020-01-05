package com.itwzhangzx.boot.dao;

import com.itwzhangzx.boot.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {
	public User selectUser(String id);

	public User selectUserByIdAndName(String id,String name);

	public User selectUserByArgs(String id,String name);

	public User selectUserByIdFromTable(@Param("id")String id, @Param("tableName")String tableName);

	public User selectUser2(User user);

	public void updateName(@Param("name") String name , @Param("id")String id);

	void insert(User user);

	void batchInsert(List<User> list);

	public List<User> selectUserFromTable(@Param("tableName")String tableName, RowBounds rowBounds);

}
