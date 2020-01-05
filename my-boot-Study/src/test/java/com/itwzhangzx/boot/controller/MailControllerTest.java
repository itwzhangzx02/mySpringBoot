package com.itwzhangzx.boot.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailControllerTest {

	private MockMvc mvc;

	@Before
	public  void  set(){
		mvc = MockMvcBuilders.standaloneSetup
				(new MailController()).build();
	}

	@Test
	public void getMailModuleProperties() throws Exception {
		mvc.perform(MockMvcRequestBuilders.
				get("/getMailModuleProperties")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().
						string(Matchers.equalTo("Hello World")));
	}
}