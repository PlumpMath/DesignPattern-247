package com.arthur.factory;

public class Rectangle implements Shape {

	@Override
	public String draw() {
		System.out.println("rectangle draw");
		return "rectangle draw";
	}

}
