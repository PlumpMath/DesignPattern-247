package com.arthur.factory;

public class Square implements Shape {

	@Override
	public String draw() {
		System.out.println("square draw");
		return "square draw";
	}

}
