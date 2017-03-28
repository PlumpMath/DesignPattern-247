package com.arthur.factory;

import org.junit.Assert;
import org.junit.Test;


public class ShapeFactoryTest {

	@Test
	public void testGetShape(){
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape rectangle = shapeFactory.getShape("rectangle");
		Assert.assertEquals("rectangle draw", rectangle.draw());
		
		Shape square = shapeFactory.getShape("square");
		Assert.assertEquals("square draw", square.draw());
		
		Shape circle = shapeFactory.getShape("circle");
		Assert.assertEquals("circle draw", circle.draw());
	}
}
