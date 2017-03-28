package com.arthur;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ReflectUtilTest {
	
	Class<?> clz;
	
	@Before
	public void init() throws Exception{
		this.clz = Class.forName("com.arthur.LoginAction");
	}

	@Test
	public void testGetGetMethods() throws Exception{
		List<Method> getMethods = ReflectUtil.getGetMethods(this.clz);
		Assert.assertEquals(3, getMethods.size());
	}
	
	@Test
	public void testGetSetMethods(){
		List<Method> setMethods = ReflectUtil.getSetMethods(this.clz);
		Assert.assertEquals(2, setMethods.size());
	}
	
	@Test
	public void testGetParametersMap(){
		LoginAction la = new LoginAction();
		la.setUsername("test");
		la.setPassword("123");
		
		Map<String, Object> params = ReflectUtil.getParametersMap(la);
		for(Map.Entry<String, Object> map : params.entrySet()){
			System.out.println(map.getKey() + "," + map.getValue());
		}
	}
	
	@Test
	public void testSetParameters() throws Exception{
		Map<String, String> params = new HashMap<String, String>();
		Object obj = Class.forName("com.arthur.LoginAction").newInstance();
		params.put("username", "test");
		params.put("password", "123");
		ReflectUtil.setParameters(params, obj);
		LoginAction la = (LoginAction) obj;
		System.out.println(la);
	}
}
