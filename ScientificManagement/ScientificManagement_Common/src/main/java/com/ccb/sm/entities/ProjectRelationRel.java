package com.ccb.sm.entities;

import java.util.Date;

/** 
* @author 作者 
* @version 创建时间：2019年12月30日 下午9:11:16 
* 类说明 
*/
public class ProjectRelationRel 
{
	//id  
	private Integer id;      
	//关联信息  
	private Integer reference_id;    
	//分类  
	private String type; 
	//项目编号  
	private Integer project_id;
	//项目名称  
	private String project_name;  
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
	private Boolean deleted;    
    //删除时间  
	private Date deleted_time;
	
	
	public ProjectRelationRel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProjectRelationRel(Integer id, Integer reference_id, String type, Integer project_id, String project_name,
			String creator, String modifier, String deleter, Date created_time, Date modified_time, Boolean deleted,
			Date deleted_time) {
		super();
		this.id = id;
		this.reference_id = reference_id;
		this.type = type;
		this.project_id = project_id;
		this.project_name = project_name;
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


	public Integer getReference_id() {
		return reference_id;
	}


	public void setReference_id(Integer reference_id) {
		this.reference_id = reference_id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getProject_id() {
		return project_id;
	}


	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}


	public String getProject_name() {
		return project_name;
	}


	public void setProject_name(String project_name) {
		this.project_name = project_name;
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


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public Date getDeleted_time() {
		return deleted_time;
	}


	public void setDeleted_time(Date deleted_time) {
		this.deleted_time = deleted_time;
	}    
	
}
