package com.hospital301.scientificmanagement.menu;

import java.util.ArrayList;
import java.util.List;

import com.ccb.sm.entities.Menu;

public class UserMenu 
{
	private String LoginNo;
	private int staffid;
	private String staffName;
	private String image;
	private List<String> permission = new ArrayList<String>();
	private List<Menu> menuTree = new ArrayList<Menu>();
	
	
	public String getLoginNo() {
		return LoginNo;
	}
	public void setLoginNo(String loginNo) {
		LoginNo = loginNo;
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<Menu> getMenuTree() {
		return menuTree;
	}

	public void setMenuTree(List<Menu> menuTree) {
		this.menuTree = menuTree;
	}
	public List<String> getPermission() {
		return permission;
	}
	public void setPermission(List<String> permission) {
		this.permission = permission;
	}
	
}
