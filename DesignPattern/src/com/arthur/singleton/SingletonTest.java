package com.arthur.singleton;

import org.junit.Assert;
import org.junit.Test;


public class SingletonTest {

	@Test
	public void testSingletonStatic(){
		System.out.println(SingletonStatic.getInstance() instanceof SingletonStatic);
		Assert.assertTrue(SingletonStatic.getInstance() instanceof SingletonStatic);
	}
}
