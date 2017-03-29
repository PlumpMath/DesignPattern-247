package com.arthur.proxy;

public class ImageProxy implements Image{
	
	private RealImage realImage;
	private String fileName;
	
	public ImageProxy(String fileName){
		this.fileName = fileName;
	}

	@Override
	public void display() {
		
		if (realImage == null) {
			this.realImage = new RealImage(this.fileName);
		}
		
		realImage.display();
	}
	

	
}
