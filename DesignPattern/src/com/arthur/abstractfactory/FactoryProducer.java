package com.arthur.abstractfactory;

public class FactoryProducer {

	public static AbstractFactory getFactory(String factoryType){
		if ("shape".equalsIgnoreCase(factoryType)) {
			return new ShapeFactory();
		}
		
		if ("color".equalsIgnoreCase(factoryType)) {
			return new ColorFactory();
		}
		
		return null;
	}
}
