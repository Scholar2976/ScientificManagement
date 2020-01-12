package com.ccb.sm.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"id", "menuId","parent","userpermission"})
public class Menu 
{
	private int id;
	private String menuId;
	private String name;
	private String href;
	private String icon;
	private String parent;
	private String userpermission;
	private List<Menu> children = new ArrayList<Menu>();
	
	public Menu(int id, String menuId, String name, String href, String icon, String parent, String userpermission) {
		super();
		this.id = id;
		this.menuId = menuId;
		this.name = name;
		this.href = href;
		this.icon = icon;
		this.parent = parent;
		this.userpermission = userpermission;
	}
	public Menu( String menuId, String name, String href, String icon, String parent) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.href = href;
		this.icon = icon;
		this.parent = parent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getUserpermission() {
		return userpermission;
	}
	public void setUserpermission(String userpermission) {
		this.userpermission = userpermission;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
	
}
