package com.arthur.abstractfactory;

public class Red implements Color {

	@Override
	public String fill() {
		System.out.println("red fill");
		return "red fill";
	}

}
