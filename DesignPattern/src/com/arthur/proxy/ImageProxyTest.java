package com.arthur.proxy;

import org.junit.Test;

public class ImageProxyTest {

	@Test
	public void testImageProxy(){
		Image image = new ImageProxy("D:/test.image");
		image.display();
		
		image.display();
	}
}
