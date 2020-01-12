package com.ccb.sm.entities;

import java.util.Date;

/** 
* @author 作者 
* @version 创建时间：2019年12月30日 下午3:47:54 
* 类说明  设备表
*/
public class ProjectEquipment 
{
	//id  
	private Integer id;      
	//所属实验室 
	private Integer lab_id;
	//室验室名称  
	private String lab_name;    
	//设备编号 
	private String equipment_id;    
	//设备名称  
	private String name;    
	//设备类型  
	private String type;   
	//所在地点  
	private String location;    
	//设备原值(万元)  
	private float price;    
	// 购入时间（年） 
	private Integer buytime;  
	//设备状态  
	private String status;   
	//管理人 
	private String manager; 
	//管理员姓名  
	private String manager_name;    
	//用途  
	private String usage;    
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
	
	
	public ProjectEquipment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProjectEquipment(Integer id, Integer lab_id, String lab_name, String equipment_id, String name, String type,
			String location, float price, Integer buytime, String status, String manager, String manager_name,
			String usage, String creator, String modifier, String deleter, Date created_time, Date modified_time,
			Boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.lab_id = lab_id;
		this.lab_name = lab_name;
		this.equipment_id = equipment_id;
		this.name = name;
		this.type = type;
		this.location = location;
		this.price = price;
		this.buytime = buytime;
		this.status = status;
		this.manager = manager;
		this.manager_name = manager_name;
		this.usage = usage;
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


	public Integer getLab_id() {
		return lab_id;
	}


	public void setLab_id(Integer lab_id) {
		this.lab_id = lab_id;
	}


	public String getLab_name() {
		return lab_name;
	}


	public void setLab_name(String lab_name) {
		this.lab_name = lab_name;
	}


	public String getEquipment_id() {
		return equipment_id;
	}


	public void setEquipment_id(String equipment_id) {
		this.equipment_id = equipment_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Integer getBuytime() {
		return buytime;
	}


	public void setBuytime(Integer buytime) {
		this.buytime = buytime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getManager_name() {
		return manager_name;
	}


	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}


	public String getUsage() {
		return usage;
	}


	public void setUsage(String usage) {
		this.usage = usage;
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
