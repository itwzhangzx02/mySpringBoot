package com.itwzhangzx.boot.service;

import com.itwzhangzx.boot.dao.UserMapper;
import com.itwzhangzx.boot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
	private UserMapper userMapper ;

	public User selectUser(String id){

		return userMapper.selectUser(id);
	}
}
