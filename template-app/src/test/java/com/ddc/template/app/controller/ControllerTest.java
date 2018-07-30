package com.ddc.template.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.ddc.template.app.modules.user.controller.AppTestController;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class ControllerTest {
	
	@Autowired
    private WebApplicationContext context;
	
	MockMvc mockMvc;

	@Before
	public void setupMock() {
		AppTestController appTestController = new AppTestController();
		mockMvc = standaloneSetup(appTestController).build();
		context.containsBean("a");
		//mockMvc = webAppContextSetup(context).build();
	}

	@Test
	public void testTestController() throws Exception {
		mockMvc.perform(get("/app/notToken")).andExpect(status().isOk()).andExpect(content().string("{\"msg\":\"无需token也能访问。。。\",\"code\":0}"));
		//mockMvc.perform(get("/app/userId")).andExpect(model().attribute("userId", 1));
	}

}
