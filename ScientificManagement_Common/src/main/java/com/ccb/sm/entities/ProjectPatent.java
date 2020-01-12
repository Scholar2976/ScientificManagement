package com.ccb.sm.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

public class ProjectPatent 
{
	//id  
	private Integer id ;      
	//专利号/申请号 
	private String patent_id ;
	//名称  
	private String title;  
	//类型/类别 (参数名：patentType)  
	private String type;  
	//发明人或设计人  
	private String inventors;
	//专利申请人  
	private String proposers;  
	//申请日期  
	private Date apply_date;
	//授权日期 
	private Date auth_date;    
	//专利权人 
	private String patentees; 
	//专利属性 (参数名：patentPropertyType)  
	private String patent_property;
	//转化情况  
	private String transform_desc;   
	//授权公告  
	private String auth_note;  
	//法律状态 (参数名：patentLawStatus)  
	private String law_status;
	//IPC主分类号 
	private String ipc_no ;
	//创建人  
	private String creator;
	//修改人  
	private String modifier;
	//删除人  
	private String deleter;
	//创建时间
	private Date created_time ;
	//更新时间  
	private Date modified_time;  
	//删除状态  
	private Boolean deleted ;
	//删除时间  
	private Date deleted_time;
	
	
	public ProjectPatent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatent_id() {
		return patent_id;
	}
	public void setPatent_id(String patent_id) {
		this.patent_id = patent_id;
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
	public String getInventors() {
		return inventors;
	}
	public void setInventors(String inventors) {
		this.inventors = inventors;
	}
	public String getProposers() {
		return proposers;
	}
	public void setProposers(String proposers) {
		this.proposers = proposers;
	}
	public Date getApply_date() {
		return apply_date;
	}
	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}
	public Date getAuth_date() {
		return auth_date;
	}
	public void setAuth_date(Date auth_date) {
		this.auth_date = auth_date;
	}
	public String getPatentees() {
		return patentees;
	}
	public void setPatentees(String patentees) {
		this.patentees = patentees;
	}
	public String getPatent_property() {
		return patent_property;
	}
	public void setPatent_property(String patent_property) {
		this.patent_property = patent_property;
	}
	public String getTransform_desc() {
		return transform_desc;
	}
	public void setTransform_desc(String transform_desc) {
		this.transform_desc = transform_desc;
	}
	public String getAuth_note() {
		return auth_note;
	}
	public void setAuth_note(String auth_note) {
		this.auth_note = auth_note;
	}
	public String getLaw_status() {
		return law_status;
	}
	public void setLaw_status(String law_status) {
		this.law_status = law_status;
	}
	public String getIpc_no() {
		return ipc_no;
	}
	public void setIpc_no(String ipc_no) {
		this.ipc_no = ipc_no;
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
