package com.ccb.sm.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ch.qos.logback.core.subst.Token.Type;

public class ProjectReward 
{
	//id  
	private Integer id;      
	//获奖证书编号  
	private String reward_id ;
	//年度  
	private Integer year;
	//奖励性质 (参数名：rewardType)  
	private String type;  
	//奖励等级 (参数名：rewardLevel)  
	private String level;
	//奖励名称  
	private String title;
	//奖励类别 (参数名：rewardCategory)  
	private String category;
	//奖励类别其它  
	private String category_other;
	//主要完成人  
	private String members;    
	//完成单位  
	private String units;   
	//领域分类  
	private String domain;    
	//成果简介 
	private String summary;
	//预期效益  
	private String expect_benefit;    
	//获奖单位排序 (参数名：rewardOrderType)  
	private String order;    
	//授奖单位  
	private String prize_unit;    
	//主要技术指标  
	private String main_technique;    
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

	
	
	public ProjectReward() {
		super();
	}



	public ProjectReward(Integer id, String reward_id, Integer year, String type, String level, String title,
			String category, String category_other, String members, String units, String domain, String summary,
			String expect_benefit, String order, String prize_unit, String main_technique, String creator,
			String modifier, String deleter, Date created_time, Date modified_time, Boolean deleted,
			Date deleted_time) {
		super();
		this.id = id;
		this.reward_id = reward_id;
		this.year = year;
		this.type = type;
		this.level = level;
		this.title = title;
		this.category = category;
		this.category_other = category_other;
		this.members = members;
		this.units = units;
		this.domain = domain;
		this.summary = summary;
		this.expect_benefit = expect_benefit;
		this.order = order;
		this.prize_unit = prize_unit;
		this.main_technique = main_technique;
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



	public String getReward_id() {
		return reward_id;
	}



	public void setReward_id(String reward_id) {
		this.reward_id = reward_id;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getLevel() {
		return level;
	}



	public void setLevel(String level) {
		this.level = level;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getCategory_other() {
		return category_other;
	}



	public void setCategory_other(String category_other) {
		this.category_other = category_other;
	}



	public String getMembers() {
		return members;
	}



	public void setMembers(String members) {
		this.members = members;
	}



	public String getUnits() {
		return units;
	}



	public void setUnits(String units) {
		this.units = units;
	}



	public String getDomain() {
		return domain;
	}



	public void setDomain(String domain) {
		this.domain = domain;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getExpect_benefit() {
		return expect_benefit;
	}



	public void setExpect_benefit(String expect_benefit) {
		this.expect_benefit = expect_benefit;
	}



	public String getOrder() {
		return order;
	}



	public void setOrder(String order) {
		this.order = order;
	}



	public String getPrize_unit() {
		return prize_unit;
	}



	public void setPrize_unit(String prize_unit) {
		this.prize_unit = prize_unit;
	}



	public String getMain_technique() {
		return main_technique;
	}



	public void setMain_technique(String main_technique) {
		this.main_technique = main_technique;
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
