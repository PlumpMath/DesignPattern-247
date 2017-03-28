package com.arthur;

import java.lang.reflect.Method;
import java.util.Map;

public class Struts {

	private static final Configuration cfg = new Configuration("src/main/resources/struts.xml");
	
	public static View runAction(String actionName, Map<String, String> parameters){
		cfg.parseXml();
		String clzName = cfg.getClass(actionName);
		
		if(clzName == null){
			return null;
		}
		
		try {
			Class<?> clz = Class.forName(clzName);
			Object action = clz.newInstance();
			
			ReflectUtil.setParameters(parameters, action);
			Method m = clz.getMethod("execute");
			
			String resultName = (String) m.invoke(action);
			
			String jsp = cfg.getViewResult(actionName, resultName);
			
			Map<String, Object> params = ReflectUtil.getParametersMap(action);
			
			View view = new View();
			view.setJsp(jsp);
			view.setParameters(params);
			
			return view;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
