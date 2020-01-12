package com.ccb.sm.entities;

import java.util.Date;

public class Parameter 
{

	private Integer id ;      
	//参数名称  
	private String name ;  
    //中文名称  
	private String cn_name ;    
	//是否启动备用1  
	private boolean use_value1;    
	//备用1标题  
	private String value1_label ;
	//备用1类型  
	private String value1_type ;   
	//是否启动备用2  
	private boolean use_value2 ;   
	//备用2标题  
	private String value2_label ;    
	//备用2类型  
	private String value2_type ;    
	//是否启动备用3  
	private boolean use_value3 ;   
	//备用3标题  
	private String value3_label;   
	//备用3类型  
	private String value3_type ;    
	//说明 
	private String memo ;
	//创建人  
	private String creator ;
	//创建时间  
	private Date created_time ;   
	//更新时间  
	private Date modified_time;   
	//删除状态  
	private boolean deleted;  
	//删除时间  
	private Date deleted_time;
	
	
	public Parameter() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Parameter(Integer id, String name, String cn_name, boolean use_value1, String value1_label,
			String value1_type, boolean use_value2, String value2_label, String value2_type, boolean use_value3,
			String value3_label, String value3_type, String memo, String creator, Date created_time, Date modified_time,
			boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.name = name;
		this.cn_name = cn_name;
		this.use_value1 = use_value1;
		this.value1_label = value1_label;
		this.value1_type = value1_type;
		this.use_value2 = use_value2;
		this.value2_label = value2_label;
		this.value2_type = value2_type;
		this.use_value3 = use_value3;
		this.value3_label = value3_label;
		this.value3_type = value3_type;
		this.memo = memo;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCn_name() {
		return cn_name;
	}


	public void setCn_name(String cn_name) {
		this.cn_name = cn_name;
	}


	public boolean isUse_value1() {
		return use_value1;
	}


	public void setUse_value1(boolean use_value1) {
		this.use_value1 = use_value1;
	}


	public String getValue1_label() {
		return value1_label;
	}


	public void setValue1_label(String value1_label) {
		this.value1_label = value1_label;
	}


	public String getValue1_type() {
		return value1_type;
	}


	public void setValue1_type(String value1_type) {
		this.value1_type = value1_type;
	}


	public boolean isUse_value2() {
		return use_value2;
	}


	public void setUse_value2(boolean use_value2) {
		this.use_value2 = use_value2;
	}


	public String getValue2_label() {
		return value2_label;
	}


	public void setValue2_label(String value2_label) {
		this.value2_label = value2_label;
	}


	public String getValue2_type() {
		return value2_type;
	}


	public void setValue2_type(String value2_type) {
		this.value2_type = value2_type;
	}


	public boolean isUse_value3() {
		return use_value3;
	}


	public void setUse_value3(boolean use_value3) {
		this.use_value3 = use_value3;
	}


	public String getValue3_label() {
		return value3_label;
	}


	public void setValue3_label(String value3_label) {
		this.value3_label = value3_label;
	}


	public String getValue3_type() {
		return value3_type;
	}


	public void setValue3_type(String value3_type) {
		this.value3_type = value3_type;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
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
