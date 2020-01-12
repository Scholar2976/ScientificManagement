package com.ccb.sm.entities;

import java.util.Date;

public class ParameterValue 
{
 
	private Integer id;      
	//参数名  
	private String parameter;
	//值  
	private String value ;    
	//标签  
	private String label ;   
	//排序码  
	private Integer order ;    
	//父值  
	private String parent ;    
	//实际子结点个数  
	private Integer real_children_count ;    
	//有效子结点个数  
	private Integer available_children_count ;  
    //链接  
	private String url;
	//备用1  
	private String value1;  
    //备用2  
	private String value2;   
	//备用3  
	private String value3;    
    //创建人  
	private String creator ;
	//创建时间  
	private Date created_time ;   
    //更新时间 
	private Date modified_time;   
	//删除状态 
	private boolean deleted ;
    //删除时间  
	private Date deleted_time;
	
	public ParameterValue() {
		super();
	}

	public ParameterValue(Integer id, String parameter, String value, String label, Integer order, String parent,
			Integer real_children_count, Integer available_children_count, String url, String value1, String value2,
			String value3, String creator, Date created_time, Date modified_time, boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.parameter = parameter;
		this.value = value;
		this.label = label;
		this.order = order;
		this.parent = parent;
		this.real_children_count = real_children_count;
		this.available_children_count = available_children_count;
		this.url = url;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		this.creator = creator;
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

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Integer getReal_children_count() {
		return real_children_count;
	}

	public void setReal_children_count(Integer real_children_count) {
		this.real_children_count = real_children_count;
	}

	public Integer getAvailable_children_count() {
		return available_children_count;
	}

	public void setAvailable_children_count(Integer available_children_count) {
		this.available_children_count = available_children_count;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
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
