package com.arthur;

public class LoginAction {

	private String username;
	private String password;
	private String message;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	
	/*public void setMessage(String message) {
		this.message = message;
	}*/
	
	public String execute(){
		if("test".equals(username) && "123".equals(password)){
			this.message = "login success";
			return "success";
		}
		this.message = "login failed please check your username/password";
		return "fail";
	}
	
	@Override
	public String toString() {
		return "LoginAction [username=" + username + ", password=" + password + ", message=" + message + "]";
	}
	
	
	
	
}
