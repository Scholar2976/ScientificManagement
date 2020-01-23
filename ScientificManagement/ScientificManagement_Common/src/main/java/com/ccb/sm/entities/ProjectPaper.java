package com.ccb.sm.entities;

import java.util.Date;

/**
 * 论文表
 * 
 * @author 29762
 *
 */
public class ProjectPaper {
	//id 
	private Integer id;
	
	//成果编号 
	private String paper_id;
	
	//论文名称 
	private String title;
	
	//发表日期 
	private String publish_date;
	 
	//通讯作者 
	private String contact;
		
	//通讯作者姓名 
	private String contact_name;
	
	//论文类型 (参数名：paperType) 
	private String type;

	//刊物名称 
	private String issue_name;

	//刊物名称 
	private String impact_factor;
	
	//第一作者 
	private String chief_authors;
	
	//其它作者 
	private String members;

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

	public ProjectPaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectPaper(Integer id, String paper_id, String title, String publish_date, String contact,
			String contact_name, String type, String issue_name, String impact_factor, String chief_authors,
			String members, String creator, String modifier, String deleter, Date created_time, Date modified_time,
			Boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.paper_id = paper_id;
		this.title = title;
		this.publish_date = publish_date;
		this.contact = contact;
		this.contact_name = contact_name;
		this.type = type;
		this.issue_name = issue_name;
		this.impact_factor = impact_factor;
		this.chief_authors = chief_authors;
		this.members = members;
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

	public String getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIssue_name() {
		return issue_name;
	}

	public void setIssue_name(String issue_name) {
		this.issue_name = issue_name;
	}

	public String getImpact_factor() {
		return impact_factor;
	}

	public void setImpact_factor(String impact_factor) {
		this.impact_factor = impact_factor;
	}

	public String getChief_authors() {
		return chief_authors;
	}

	public void setChief_authors(String chief_authors) {
		this.chief_authors = chief_authors;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
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
