package com.example.myspringbootapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class MySpringBootAppApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	@Before
	public void setMockMvc(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}
	@Test
	public void homePage() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/index"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("/index"));
	}

}
