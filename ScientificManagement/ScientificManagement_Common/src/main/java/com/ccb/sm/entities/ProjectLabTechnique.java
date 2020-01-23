package com.ccb.sm.entities;

import java.util.Date;

import sun.security.x509.PrivateKeyUsageExtension;

/** 
* @author 作者 
* @version 创建时间：2019年12月30日 下午3:56:03 
* 类说明 
*/
public class ProjectLabTechnique 
{
	//id  
	private Integer id;    
	//所属实验室  
	private Integer lab_id; 
	//主要技术说明 
	private String desc;   
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
	
	public ProjectLabTechnique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectLabTechnique(Integer id, Integer lab_id, String desc, String creator, String modifier, String deleter,
			Date created_time, Date modified_time, Boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.lab_id = lab_id;
		this.desc = desc;
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

	public Integer getLab_id() {
		return lab_id;
	}

	public void setLab_id(Integer lab_id) {
		this.lab_id = lab_id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
