package com.ccb.sm.entities;

import java.security.KeyStore.PrivateKeyEntry;

import com.fasterxml.jackson.annotation.JsonProperty;

/** 
* @author 作者 
* @version 创建时间：2020年1月21日 下午3:08:13 
* 类说明 
*/
public class RoleUserRel 
{
	 //id  
	private Integer id;      
	//角色名 
	@JsonProperty("name")
	private String role;
	//用户ID  
	private String username;
	//用户名  
	private String nickname;
	
	
	public RoleUserRel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RoleUserRel(Integer id, String role, String username, String nickname) {
		super();
		this.id = id;
		this.role = role;
		this.username = username;
		this.nickname = nickname;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

}
