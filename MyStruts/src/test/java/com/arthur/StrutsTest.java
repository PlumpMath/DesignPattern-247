package com.arthur;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


public class StrutsTest {

	@Test
	public void testLoginActionSuccess(){
		
		String actionName = "login";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "test");
		params.put("password", "123");
		
		View view = Struts.runAction(actionName, params);
		
		Assert.assertEquals("/jsp/homepage.jsp", view.getJsp());
		Assert.assertEquals("login success", view.getParameters().get("message"));
	}
	
	@Test
	public void testLoginActionFail(){
		
		String actionName = "login";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "test");
		params.put("password", "123456");
		
		View view = Struts.runAction(actionName, params);
		
		Assert.assertEquals("/jsp/showLogin.jsp", view.getJsp());
		Assert.assertEquals("login failed please check your username/password", view.getParameters().get("message"));
	}
}
