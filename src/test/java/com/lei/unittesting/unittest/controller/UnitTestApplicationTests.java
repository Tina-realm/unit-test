package com.lei.unittesting.unittest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value=HelloWorldController.class)
class UnitTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloWorld_basic() throws Exception{
		//call GET "/hello-world" application/json
		RequestBuilder request= MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result= mockMvc
				.perform(request)
				.andExpect(status().is(200))
				.andExpect(content().string("Hello"))
				.andReturn();

		//assertEquals("Hello World", result.getResponse().getContentAsString());

		// verify "Hello World"
	}

}
