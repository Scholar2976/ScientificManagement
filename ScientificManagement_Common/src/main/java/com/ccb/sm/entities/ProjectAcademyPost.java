package com.ccb.sm.entities;

import java.util.Date;

public class ProjectAcademyPost {
	
	private Integer id;      
	//学会ID  
	private Integer academy_id; 
	//学会名称  
	private String academy_name;    
	//学会职务 (参数名：academyDutyType)  
	private String duty;    
	//用户  
	private String username;
	//用户姓名  
	private String nickname;    
	//任职开始时间  
	private Date begin_date;    
	//任职结束时间  
	private Date end_date;    
	//创建人  
	private String creator;
	//修改人 
	private String modifier; 
	//删除人  
	private String deleter;
	//创建时间  
	private Date created_time;    
	//更新时间  
	private Date modified_time;    
	//删除状态 
	private boolean deleted;  
	//删除时间  
	private Date deleted_time;
	
	public ProjectAcademyPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectAcademyPost(Integer id, Integer academy_id, String academy_name, String duty, String username,
			String nickname, Date begin_date, Date end_date, String creator, String modifier, String deleter,
			Date created_time, Date modified_time, boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.academy_id = academy_id;
		this.academy_name = academy_name;
		this.duty = duty;
		this.username = username;
		this.nickname = nickname;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.creator = creator;
		this.modifier = modifier;
		this.deleter = deleter;
		this.created_time = created_time;
		this.modified_time = modified_time;
		this.deleted = deleted;
		this.deleted_time = deleted_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAcademy_id() {
		return academy_id;
	}

	public void setAcademy_id(Integer academy_id) {
		this.academy_id = academy_id;
	}

	public String getAcademy_name() {
		return academy_name;
	}

	public void setAcademy_name(String academy_name) {
		this.academy_name = academy_name;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
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

	public Date getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getDeleter() {
		return deleter;
	}

	public void setDeleter(String deleter) {
		this.deleter = deleter;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Date getModified_time() {
		return modified_time;
	}

	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getDeleted_time() {
		return deleted_time;
	}

	public void setDeleted_time(Date deleted_time) {
		this.deleted_time = deleted_time;
	}
	
}
