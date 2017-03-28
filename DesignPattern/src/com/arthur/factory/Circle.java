package com.arthur.factory;

public class Circle implements Shape {

	@Override
	public String draw() {
		System.out.println("circle draw");
		return "circle draw";
	}

}
