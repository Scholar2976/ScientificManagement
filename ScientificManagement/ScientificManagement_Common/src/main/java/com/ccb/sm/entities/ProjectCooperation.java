package com.ccb.sm.entities;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.Date;

/** 
* @author 作者 
* @version 创建时间：2020年1月13日 下午7:53:01 
* 类说明 
*/
public class ProjectCooperation 
{
	//id  
	private Integer id ;      
	//课题名称  
	private String name ;      
	//国家(地区) (参数名：nation)  
	private String nation ;   
	//技术领域 (参数名：cooperationDomain)  
	private String domain;  
	//技术领域其它  
	private String domain_other;
	//中方经费(万元)  
	private float chinese_fund;    
	// 其中:政府投入(万元)  
	private float gov_fund;  
	//外方经费(万元)  
	private float foreign_fund;
	//中方执行单位  
	private String execution_unit;
	//外方执行单位 
	private String execution_outer_unit;
	//执行年限(年)  
	private Integer execution_year;  
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
	
	
	public ProjectCooperation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProjectCooperation(Integer id, String name, String nation, String domain, String domain_other,
			float chinese_fund, float gov_fund, float foreign_fund, String execution_unit, String execution_outer_unit,
			Integer execution_year, String creator, String modifier, String deleter, Date created_time,
			Date modified_time, Boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.name = name;
		this.nation = nation;
		this.domain = domain;
		this.domain_other = domain_other;
		this.chinese_fund = chinese_fund;
		this.gov_fund = gov_fund;
		this.foreign_fund = foreign_fund;
		this.execution_unit = execution_unit;
		this.execution_outer_unit = execution_outer_unit;
		this.execution_year = execution_year;
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


	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}


	public String getDomain() {
		return domain;
	}


	public void setDomain(String domain) {
		this.domain = domain;
	}


	public String getDomain_other() {
		return domain_other;
	}


	public void setDomain_other(String domain_other) {
		this.domain_other = domain_other;
	}


	public float getChinese_fund() {
		return chinese_fund;
	}


	public void setChinese_fund(float chinese_fund) {
		this.chinese_fund = chinese_fund;
	}


	public float getGov_fund() {
		return gov_fund;
	}


	public void setGov_fund(float gov_fund) {
		this.gov_fund = gov_fund;
	}


	public float getForeign_fund() {
		return foreign_fund;
	}


	public void setForeign_fund(float foreign_fund) {
		this.foreign_fund = foreign_fund;
	}


	public String getExecution_unit() {
		return execution_unit;
	}


	public void setExecution_unit(String execution_unit) {
		this.execution_unit = execution_unit;
	}


	public String getExecution_outer_unit() {
		return execution_outer_unit;
	}


	public void setExecution_outer_unit(String execution_outer_unit) {
		this.execution_outer_unit = execution_outer_unit;
	}


	public Integer getExecution_year() {
		return execution_year;
	}


	public void setExecution_year(Integer execution_year) {
		this.execution_year = execution_year;
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
