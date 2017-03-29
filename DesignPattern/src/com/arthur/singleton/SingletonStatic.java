package com.arthur.singleton;

public class SingletonStatic {

	private static class SingletonHolder{
		private static final SingletonStatic INSTANCE = new SingletonStatic();
	}
	
	private SingletonStatic(){}
	
	public static final SingletonStatic getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
