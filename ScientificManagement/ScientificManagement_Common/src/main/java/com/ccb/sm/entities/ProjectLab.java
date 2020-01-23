package com.ccb.sm.entities;

import java.util.Date;

import sun.security.x509.PrivateKeyUsageExtension;

/** 
* @author 作者 
* @version 创建时间：2019年12月30日 上午10:30:54 
* 类说明 
*/
public class ProjectLab 
{
	//id  
	private Integer id;     
	///类别 (参数名：labCategoryType)  
	private String category;
	//实验室名称 
	private String name ;  
	//所在地点 
	private String location;
	//面积(M2)  
	private Integer area;    
	//负责人 
	private String leader;
    //负责人姓名  
	private String leader_name;   
	//依托单位 
	private String unit;  
	//主管部门 
	private String competent_department;
	//研究方向  
	private String research_direction; 
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
	
	
	
	public ProjectLab() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProjectLab(Integer id, String category, String name, String location, Integer area, String leader,
			String leader_name, String unit, String competent_department, String research_direction, String creator,
			String modifier, String deleter, Date created_time, Date modified_time, Boolean deleted,
			Date deleted_time) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.location = location;
		this.area = area;
		this.leader = leader;
		this.leader_name = leader_name;
		this.unit = unit;
		this.competent_department = competent_department;
		this.research_direction = research_direction;
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



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Integer getArea() {
		return area;
	}



	public void setArea(Integer area) {
		this.area = area;
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



	public String getUnit() {
		return unit;
	}



	public void setUnit(String unit) {
		this.unit = unit;
	}



	public String getCompetent_department() {
		return competent_department;
	}



	public void setCompetent_department(String competent_department) {
		this.competent_department = competent_department;
	}



	public String getResearch_direction() {
		return research_direction;
	}



	public void setResearch_direction(String research_direction) {
		this.research_direction = research_direction;
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



	public Boolean isDeleted() {
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
