package com.arthur.abstractfactory;

import org.junit.Assert;
import org.junit.Test;


public class AbstractFactoryTest {

	@Test
	public void testGetFactory(){
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		Shape circle = shapeFactory.getShape("circle");
		Assert.assertEquals("circle draw", circle.draw());
		
		AbstractFactory colorFactory = FactoryProducer.getFactory("color");
		Color red = colorFactory.getColor("red");
		Assert.assertEquals("red fill", red.fill());
	}
}
