package com.ccb.sm.entities;

import java.util.Date;

import sun.security.x509.PrivateKeyUsageExtension;

/** 
* @author 作者 
* @version 创建时间：2019年12月30日 下午3:23:19 
* 类说明  项目表
*/
public class Project 
{
	//id  
	private Integer id;      
	//课题编号  
	private String project_id;    
	//课题名称  
	private String name;    
	//项目来源 (参数名：projectSource)  
	private String source;    
	//其它  
	private String source_other;    
	//申报类别  
	private String apply_type;    
	//课题级别  
	private String level;    
	//保密等级  
	private String security_level;    
	//合作形式 (参数名：projectCooperationType)  
	private String cooperation_type;    
	//课题负责人  
	private String leader;
	//课题负责人姓名  
	private String leader_name;   
	//成员  
	private String members;    
	//承担单位  
	private String duty_unit;    
	//合作单位  
	private String units;    
	//开始日期  
	private Date begin_date;    
	//结束日期  
	private Date end_date;    
	//项目批准时间  
	private Date approved_date;    
	// 批准经费（万元） 
	private float approved_fund;  
	//领域分类 (参数名：classification)  
	private String domain;   
	//研究目标及内容  
	private String target_content;   
	//审核状态  
	private String approve_status;   
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
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(Integer id, String project_id, String name, String source, String source_other, String apply_type,
			String level, String security_level, String cooperation_type, String leader, String leader_name,
			String members, String duty_unit, String units, Date begin_date, Date end_date, Date approved_date,
			float approved_fund, String domain, String target_content, String approve_status, String creator,
			String modifier, String deleter, Date created_time, Date modified_time, Boolean deleted,
			Date deleted_time) {
		super();
		this.id = id;
		this.project_id = project_id;
		this.name = name;
		this.source = source;
		this.source_other = source_other;
		this.apply_type = apply_type;
		this.level = level;
		this.security_level = security_level;
		this.cooperation_type = cooperation_type;
		this.leader = leader;
		this.leader_name = leader_name;
		this.members = members;
		this.duty_unit = duty_unit;
		this.units = units;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.approved_date = approved_date;
		this.approved_fund = approved_fund;
		this.domain = domain;
		this.target_content = target_content;
		this.approve_status = approve_status;
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

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource_other() {
		return source_other;
	}

	public void setSource_other(String source_other) {
		this.source_other = source_other;
	}

	public String getApply_type() {
		return apply_type;
	}

	public void setApply_type(String apply_type) {
		this.apply_type = apply_type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSecurity_level() {
		return security_level;
	}

	public void setSecurity_level(String security_level) {
		this.security_level = security_level;
	}

	public String getCooperation_type() {
		return cooperation_type;
	}

	public void setCooperation_type(String cooperation_type) {
		this.cooperation_type = cooperation_type;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getLeader_name() {
		return leader_name;
	}

	public void setLeader_name(String leader_name) {
		this.leader_name = leader_name;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getDuty_unit() {
		return duty_unit;
	}

	public void setDuty_unit(String duty_unit) {
		this.duty_unit = duty_unit;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
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

	public Date getApproved_date() {
		return approved_date;
	}

	public void setApproved_date(Date approved_date) {
		this.approved_date = approved_date;
	}

	public float getApproved_fund() {
		return approved_fund;
	}

	public void setApproved_fund(float approved_fund) {
		this.approved_fund = approved_fund;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getTarget_content() {
		return target_content;
	}

	public void setTarget_content(String target_content) {
		this.target_content = target_content;
	}

	public String getApprove_status() {
		return approve_status;
	}

	public void setApprove_status(String approve_status) {
		this.approve_status = approve_status;
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
