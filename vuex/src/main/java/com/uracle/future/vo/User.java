package com.uracle.future.vo;

public class User {
	private String id;
	private String name;
	private String pwd;
	private String naverState;
	private String email;
	private Integer pnt;
	private String lastLogin;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNaverState() {
		return naverState;
	}
	public void setNaverState(String naverState) {
		this.naverState = naverState;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getPnt() {
		return pnt;
	}
	public void setPnt(Integer pnt) {
		this.pnt = pnt;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
}
