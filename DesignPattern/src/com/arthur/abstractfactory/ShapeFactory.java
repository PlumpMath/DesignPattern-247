package com.arthur.abstractfactory;

public class ShapeFactory extends AbstractFactory{

	public Shape getShape(String shapeType){
		
		if ("circle".equalsIgnoreCase(shapeType)) {
			return new Circle();
		}
		
		return null;
	}

	@Override
	Color getColor(String colorType) {
		return null;
	}
	
}
