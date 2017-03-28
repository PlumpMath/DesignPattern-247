package com.arthur.abstractfactory;

public class Circle implements Shape{

	@Override
	public String draw() {
		System.out.println("circle draw");
		return "circle draw";
	}

	
}
