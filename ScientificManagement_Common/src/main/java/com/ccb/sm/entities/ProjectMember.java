package com.ccb.sm.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 课题成员表
 * @author 29762
 *
 */
public class ProjectMember 
{
	//id  
	private Integer id ;      
	//所属ID  
	private Integer reference_id ;  
	//用户ID  
	private String username; 
	//姓名 
	private String nickname;   
	//人员性质 
	private String user_property ;
	//工作单位  
	private String unit;  
	//科室 
	private String organization_id;
	//科室  
	private String organization_name ;
	//职称  
	private String rank ;
	//本项目承担任务  
	private String duty;  
	//关联类型  
	private String type;   
	//子关联类型  
	private String subtype; 
	//排名  
	private String ranking;
	//排序码  
	private Integer order ;   
	//关联日期  
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;   
	//创建人  
	private String creator ;
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
	public ProjectMember() {
		super();
	}
	public ProjectMember(Integer id, Integer reference_id, String username, String nickname, String user_property,
			String unit, String organization_id, String organization_name, String rank, String duty, String type,
			String subtype, String ranking, Integer order, Date date, String creator, String modifier, String deleter,
			Date created_time, Date modified_time, boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.reference_id = reference_id;
		this.username = username;
		this.nickname = nickname;
		this.user_property = user_property;
		this.unit = unit;
		this.organization_id = organization_id;
		this.organization_name = organization_name;
		this.rank = rank;
		this.duty = duty;
		this.type = type;
		this.subtype = subtype;
		this.ranking = ranking;
		this.order = order;
		this.date = date;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUser_property() {
		return user_property;
	}
	public void setUser_property(String user_property) {
		this.user_property = user_property;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(String organization_id) {
		this.organization_id = organization_id;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
