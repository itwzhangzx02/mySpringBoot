package com.itwzhangzx.boot.controller;

import com.itwzhangzx.boot.MyAppDemo;
import com.itwzhangzx.boot.dao.UserByH2DatabaseMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAppDemo.class)
public class SimpleTest {

    @Resource
	UserByH2DatabaseMapper userByH2DatabaseMapper ;
    @Test
	public  void test(){
		userByH2DatabaseMapper.selectAll();
		userByH2DatabaseMapper.selectByName("Tom");
		userByH2DatabaseMapper.selectUser("Jack");
	}
}