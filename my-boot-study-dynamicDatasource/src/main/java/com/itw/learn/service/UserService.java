package com.itw.learn.service;

import com.itw.learn.config.TargetDatasource;
import com.itw.learn.dao.UserMapper;
import com.itw.learn.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    @TargetDatasource("slave1")
    public User select(){
        return userMapper.selectOne("10");
    }
}
