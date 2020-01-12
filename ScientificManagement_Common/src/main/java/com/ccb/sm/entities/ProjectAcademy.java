package com.ccb.sm.entities;

import java.util.Date;

/**
 * @author 作者
 * @version 创建时间：2019年12月25日 下午3:38:55 类说明
 */
public class ProjectAcademy {
	private Integer id;
	// 学会名称
	private String name;
	// 学会级别 (参数名：academyLevelType)
	private String academy_level;
	// 管理部门
	private String management;
	// 负责人
	private String leader_id;
	// 负责人姓名
	private String leader_name;
	// 创建人
	private String creator;
	// 修改人
	private String modifier;
	// 删除人
	private String deleter;
	// 创建时间
	private Date created_time;
	// 更新时间
	private Date modified_time;
	// 删除状态
	private Boolean deleted;
	// 删除时间
	private Date deleted_time;

	public ProjectAcademy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectAcademy(Integer id, String name, String academy_level, String management, String leader_id,
			String leader_name, String creator, String modifier, String deleter, Date created_time, Date modified_time,
			Boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.name = name;
		this.academy_level = academy_level;
		this.management = management;
		this.leader_id = leader_id;
		this.leader_name = leader_name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcademy_level() {
		return academy_level;
	}

	public void setAcademy_level(String academy_level) {
		this.academy_level = academy_level;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}

	public String getLeader_id() {
		return leader_id;
	}

	public void setLeader_id(String leader_id) {
		this.leader_id = leader_id;
	}

	public String getLeader_name() {
		return leader_name;
	}

	public void setLeader_name(String leader_name) {
		this.leader_name = leader_name;
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
