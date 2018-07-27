package com.uracle.future.vo;

public class Menu {
	private String menu_id;
	private String par_menu_id;
	private String deep;
	private String menu_name;
	private String url;
	private String use_yn;
	private String insert_dt;
	private String insert_id;
	private String update_dt;
	private String update_id;
	private String path;
	private String sort;
	private String menu_group;
	
	public String getMenu_group() {
		return menu_group;
	}
	public void setMenu_group(String menu_group) {
		this.menu_group = menu_group;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getPar_menu_id() {
		return par_menu_id;
	}
	public void setPar_menu_id(String par_menu_id) {
		this.par_menu_id = par_menu_id;
	}
	public String getDeep() {
		return deep;
	}
	public void setDeep(String deep) {
		this.deep = deep;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getInsert_dt() {
		return insert_dt;
	}
	public void setInsert_dt(String insert_dt) {
		this.insert_dt = insert_dt;
	}
	public String getInsert_id() {
		return insert_id;
	}
	public void setInsert_id(String insert_id) {
		this.insert_id = insert_id;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	public String getUpdate_id() {
		return update_id;
	}
	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}