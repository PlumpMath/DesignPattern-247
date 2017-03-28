package com.arthur.factory;

public class ShapeFactory {

	public Shape getShape(String shapeType){
		if (shapeType == null) {
			return null;
		}
		
		if ("rectangle".equalsIgnoreCase(shapeType)) {
			return new Rectangle();
		}
		
		if ("square".equalsIgnoreCase(shapeType)) {
			return new Square();
		}
		
		if ("circle".equalsIgnoreCase(shapeType)) {
			return new Circle();
		}
		
		return null;
	}
}
