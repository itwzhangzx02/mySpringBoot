package com.itwzhangzx.boot.controller;

import com.itwzhangzx.boot.MyAppDemo;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAppDemo.class)
@WebAppConfiguration
public class MailControllerTest {

	@Autowired
	private WebApplicationContext context ;

	private MockMvc mvc;

	//因为我们这儿测试时controller层依赖service等，所以构建时，直接加载容器
	@Before
	public  void  set(){
		mvc = MockMvcBuilders.webAppContextSetup(context)
				.build();
	}

	@Test
	public void getMailModuleProperties() throws Exception {
		System.out.println(mvc.perform(MockMvcRequestBuilders.
				get("/getMailModuleProperties")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn());
		//.andExpect(content().string(Matchers.equalTo("Hello World")));
	}

	@Test
	public void getHelloWorld() throws Exception {
		mvc.perform(MockMvcRequestBuilders.
				get("/HELLO")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(Matchers.equalTo("hello world ")));
	}
}