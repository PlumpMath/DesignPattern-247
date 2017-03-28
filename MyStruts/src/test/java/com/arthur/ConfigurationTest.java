package com.arthur;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ConfigurationTest {

	private Configuration config;
	
	@Before
	public void init(){
		String url = "src/main/resources/struts.xml";
		this.config = new Configuration(url);
		this.config.parseXml();
	}
	
	@Test
	public void testGetFile(){
		InputStream is = this.config.getFile();
	}
	
	@Test
	public void testParseXml(){
		this.config.parseXml();
	}
	
	@Test
	public void testGetClassName(){
		Assert.assertEquals("com.arthur.LoginAction", this.config.getClass("login"));
	}
	
	@Test
	public void testGetViewResult(){
		String jsp = this.config.getViewResult("login","success");
		Assert.assertEquals("/jsp/homepage.jsp", jsp);
	}
}
