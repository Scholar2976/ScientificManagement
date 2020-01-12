package com.ccb.sm.entities;

import java.util.Date;

public class Organization 
{
	//id  
	private Integer id;
	
	//Name  
	private String name;
	
	//部门编号  
	private String org_id;    
	
	//机构类型  
	private String type;    
	
	//创建时间  
	private Date created_time;
	
	//更新时间  
	private Date modified_time;    
	   
	//删除状态  
	private boolean deleted;    
	   
    //删除时间  
	private Date deleted_time;

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization(Integer id, String name, String org_id, String type, Date created_time, Date modified_time,
			boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.name = name;
		this.org_id = org_id;
		this.type = type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
