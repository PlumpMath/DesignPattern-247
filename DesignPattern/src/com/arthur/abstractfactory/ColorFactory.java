package com.arthur.abstractfactory;

public class ColorFactory extends AbstractFactory{

	public Color getColor(String colorType){
		
		if ("red".equalsIgnoreCase(colorType)) {
			return new Red();
		}
		
		return null;
	}

	@Override
	Shape getShape(String shapeType) {
		return null;
	}
}
