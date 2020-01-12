package com.ccb.sm.entities;

import java.util.Date;

/**
 * 论文表
 * 
 * @author 29762
 *
 */
public class ProjectPaper {
	// id
	private int id;

	// 通讯作者
	private String contact;

	// 通讯作者姓名
	private String contact_name;

	// 创建时间 DATETIME
	private Date created_time;

	// 删除状态
	private boolean deleted;

	// 删除时间
	private Date deleted_time;

	// 刊物名称
	private String impact_factor;

	// 刊物名称
	private String issue_name;

	// 更新时间
	private Date modified_time;

	// 成果编号
	private String paper_id;

	// 课题编号
	private String project_id;

	// 标题
	private String title;

	// 论文类型
	private String type;
	

	public ProjectPaper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectPaper(int id, String contact, String contact_name, Date created_time, boolean deleted,
			Date deleted_time, String impact_factor, String issue_name, Date modified_time, String paper_id,
			String project_id, String title, String type) {
		super();
		this.id = id;
		this.contact = contact;
		this.contact_name = contact_name;
		this.created_time = created_time;
		this.deleted = deleted;
		this.deleted_time = deleted_time;
		this.impact_factor = impact_factor;
		this.issue_name = issue_name;
		this.modified_time = modified_time;
		this.paper_id = paper_id;
		this.project_id = project_id;
		this.title = title;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
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

	public String getImpact_factor() {
		return impact_factor;
	}

	public void setImpact_factor(String impact_factor) {
		this.impact_factor = impact_factor;
	}

	public String getIssue_name() {
		return issue_name;
	}

	public void setIssue_name(String issue_name) {
		this.issue_name = issue_name;
	}

	public Date getModified_time() {
		return modified_time;
	}

	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}

	public String getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(String paper_id) {
		this.paper_id = paper_id;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
