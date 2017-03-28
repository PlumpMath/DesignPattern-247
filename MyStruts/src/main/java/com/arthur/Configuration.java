package com.arthur;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Configuration {
	
	private String url;
	
	Map<String, ActionConfig> actions = new HashMap<String, ActionConfig>();

	/**
	 * 获取文件流
	 * @return
	 */
	public InputStream getFile() {
		File file = new File(this.url);
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return is;
	}
	
	/**
	 * 解析XML
	 * 将解析后的对象封装成一个map
	 */
	public void parseXml(){
		InputStream is = this.getFile();
		SAXBuilder builder = new SAXBuilder();
		
		try {
			Document doc = builder.build(is);
			Element root = doc.getRootElement();
			
			List<Element> children = root.getChildren("action");
			
			for(Element actionElement : children){
				String actionName = actionElement.getAttributeValue("name");
				String actionClass = actionElement.getAttributeValue("class");
				ActionConfig ac = new ActionConfig(actionName, actionClass);
				
				List<Element> resultChildren = actionElement.getChildren("result");
				for(Element resultName : resultChildren){
					String name = resultName.getAttributeValue("name");
					String text = resultName.getText();
					ac.addViewResult(name, text);
				}
				
				this.actions.put(actionName, ac);
			}
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public String getClass(String actionName){
		ActionConfig ac = this.actions.get(actionName);
		if(ac == null){
			return null;
		}
		return ac.getClassName();
	}
	
	public String getViewResult(String actionName, String resultName) {
		ActionConfig ac = this.actions.get(actionName);
		if(ac == null){
			return null;
		}
		return ac.getViewResult(resultName);
	}
	
	private Configuration() {}

	public Configuration(String url) {
		this.url = url;
	}
	
	private static class ActionConfig{
		String name;
		String clzName;
		Map<String, String> viewResult = new HashMap<String, String>();
		
		public ActionConfig(String name, String clzName) {
			this.name = name;
			this.clzName = clzName;
		}

		public String getClassName(){
			return this.clzName;
		}
		
		public void addViewResult(String name, String viewName){
			this.viewResult.put(name, viewName);
		}
		
		public String getViewResult(String name){
			return this.viewResult.get(name);
		}
		
	}

	
	
}
