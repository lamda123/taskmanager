package com.example.taskmanager;

import com.example.taskmanager.profile.User;
import com.example.taskmanager.profile.UserResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.constraints.AssertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
class TaskManagerApplicationTests {
    @Autowired
	private MockMvc mockMvc;
    @Autowired
	private WebApplicationContext webApplicationContext;

    ObjectMapper objectMapper = new ObjectMapper();
    @Before
    public void setUp(){
     mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
	public void addEmployeeTest()throws JsonProcessingException,Exception {
    	User user = new User();
    	user.setEmail("xyz123@gmail.com");
    	user.setName("Basant");
    	user.setPassword("#dkfjdkf");
    	//user.setPic(new byte[]{5,6,9,11});
    	String jsonRequest = objectMapper.writeValueAsString(user);
	    MvcResult result =  mockMvc.perform(post("/sign-up/submit").content(jsonRequest).content(
			    MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
/*

	    String resultContent = result.getResponse().getContentAsString();
	    String response = objectMapper.readValues(resultContent,UserResponse.class)
	  //   Assert.assertSame(response.g);
*/

    }

}
