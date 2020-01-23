package com.ccb.sm.entities;

import java.util.Date;

public class OrgOrgRel 
{
	//id  
	private Integer id ;      
	//上级部门 
	private String parent;
	//部门  
	private String org;    
	//关系类型 
	private String type;   
	//顺序号  
	private Integer order;    
	//Number of Children  
	private Integer number_of_children;   
	//Number of People  
	private Integer number_of_people;  
	//创建时间  
	private Date created_time;    
	//更新时间 
	private Date modified_time;    
	//删除状态  
	private boolean deleted;    
	//删除时间  
	private Date deleted_time;
	
	public OrgOrgRel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrgOrgRel(Integer id, String parent, String org, String type, Integer order, Integer number_of_children,
			Integer number_of_people, Date created_time, Date modified_time, boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.parent = parent;
		this.org = org;
		this.type = type;
		this.order = order;
		this.number_of_children = number_of_children;
		this.number_of_people = number_of_people;
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
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getNumber_of_children() {
		return number_of_children;
	}
	public void setNumber_of_children(Integer number_of_children) {
		this.number_of_children = number_of_children;
	}
	public Integer getNumber_of_people() {
		return number_of_people;
	}
	public void setNumber_of_people(Integer number_of_people) {
		this.number_of_people = number_of_people;
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
