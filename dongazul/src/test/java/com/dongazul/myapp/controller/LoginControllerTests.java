package com.dongazul.myapp.controller;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@WebAppConfiguration

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {
			"file:src/main/webapp/WEB-INF/spring/root-context.xml",
			"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class LoginControllerTests {
	
	@Setter(onMethod_=@Autowired)
	private WebApplicationContext ctx;

	
	@Before
	public void setup() {
		log.debug("setup() invoked.");
		
		assert this.ctx != null;
		log.info("\t+ ctx : " + this.ctx);
		
	} // setup
	
	
	@Test
	public void testSignIn() throws Exception {
		log.debug("testSignIn() invoked.");
		
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		
		MockMvc mockMvc = mockMvcBuilder.build();
		
		MockHttpServletRequestBuilder reqBuilder =
					MockMvcRequestBuilders.post("/login/signIn");
		
		reqBuilder.param("email", "bompig@pig.bom");
		reqBuilder.param("passwd", "8520");
		
		ResultActions resultActions = mockMvc.perform(reqBuilder);
		
		MvcResult mvcResult = resultActions.andReturn();
		
		ModelAndView modelAndView = mvcResult.getModelAndView();
		
		Map<String, Object> model = modelAndView.getModel();
		
		String viewName = modelAndView.getViewName();
		
	} // testSignIn
	
	
	@Test
	public void testSignOut() throws Exception {
		log.debug("testSignOut() invoked.");
		
		MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
		
		MockMvc mockMvc = mockMvcBuilder.build();
		
		MockHttpServletRequestBuilder reqBuilder =
				MockMvcRequestBuilders.get("/login/signOut");
		
		reqBuilder.param(null, null);
		
		ResultActions resultActions = mockMvc.perform(reqBuilder);
		
		MvcResult mvcResult = resultActions.andReturn();
		
		ModelAndView modelAndView = mvcResult.getModelAndView();
		
		Map<String, Object> model = modelAndView.getModel();
		
		String viewName = modelAndView.getViewName();
				
	} // testSignOut
	
	
	@After
	public void tearDown() {
		log.debug("tearDown() invoked.");
		
		
		
	} // tearDown
	
} // end class
