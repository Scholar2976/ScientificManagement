package com.ccb.sm.entities;

import java.util.Date;

import sun.security.x509.PrivateKeyUsageExtension;

/** 
* @author 作者 
* @version 创建时间：2019年12月30日 下午3:12:50 
* 类说明  关键字表
*/
public class ProjectKeyword 
{
	//id  
	private Integer id;      
	//所属ID  
	private Integer reference_id;
	//关键字  
	private String keyword;
	//关联类型  
	private String type;    
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
	
	
	public ProjectKeyword() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProjectKeyword(Integer id, Integer reference_id, String keyword, String type, String creator,
			String modifier, String deleter, Date created_time, Date modified_time, boolean deleted,
			Date deleted_time) {
		super();
		this.id = id;
		this.reference_id = reference_id;
		this.keyword = keyword;
		this.type = type;
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


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
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
