package com.gayatri.accountservice.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationErrorControllerTest {

	@Autowired
	private MockMvc mvc;

	/* Integration Tests */

	@Test
	public void applicationErrorTest() throws Exception {
		
		String jsonOutput = "{\"errorMsg\":\"Something went wrong!\",\"errorCode\":400}";
		
		mvc.perform(MockMvcRequestBuilders.get("/error"))
		.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
		.andExpect(content().json(jsonOutput));
		
		
	}

}
