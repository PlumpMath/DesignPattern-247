package com.arthur;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectUtil {
	
	public static void setParameters(Map<String, String> params, Object obj){
		Class<?> clz = obj.getClass();
		
		for(Method m : getSetMethods(clz)){
			String methodName =  m.getName();
			for(Map.Entry<String, String> map : params.entrySet()){
				String name = "set" + map.getKey();
				if(name.equalsIgnoreCase(methodName)){
					try {
						m.invoke(obj, map.getValue());
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	public static Map<String, Object> getParametersMap(Object obj){
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		
		Class<?> clz = obj.getClass();
		
		for(Method m : getGetMethods(clz)){
			String methodName = m.getName();
			String name = methodName.replaceFirst("get", "").toLowerCase();
			
			try {
				Object value = m.invoke(obj);
				parametersMap.put(name, value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		}
		
		return parametersMap;
	}
	
	public static List<Method> getSetMethods(Class<?> clz){
		return getMethods(clz, "set");
	}
	
	public static List<Method> getGetMethods(Class<?> clz){
		return getMethods(clz, "get");
	}

	private static List<Method> getMethods(Class<?> clz, String methodName){
		List<Method> methods = new ArrayList<Method>();
		
		for(Method method : clz.getDeclaredMethods()){
			if(method.getName().startsWith(methodName)){
				methods.add(method);
			}
		}
		return methods;
	}
}
