package com.ccb.sm.entities;

import java.util.Date;

/** 
* @author 作者 
* @version 创建时间：2020年1月4日 下午5:06:33 
* 类说明 
*/
public class ProjectSoftware
{
	//id  
	private Integer id ;      
	//登记号  
	private String register_id;
    //名称  
	private String name;  
	//著作权人  
	private String author;
	//著作权人姓名  
	private String author_name ;
    //登记日期  
	private Date register_date;  
	//开发完成时间 
	private Date finish_date;   
    //软件著作权属性 (参数名：softwarePropertyType)  
	private String property;    
	//软件分类号 (参数名：softwareCategoryType)  
	private String category_id;  
	//开发方式 (参数名：softwareDevelopmentType)  
	private String development_mode; 
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
	private Boolean deleted;
    //删除时间  
	private Date deleted_time;
	
	public ProjectSoftware() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectSoftware(Integer id, String register_id, String name, String author, String author_name,
			Date register_date, Date finish_date, String property, String category_id, String development_mode,
			String creator, String modifier, String deleter, Date created_time, Date modified_time, Boolean deleted,
			Date deleted_time) {
		super();
		this.id = id;
		this.register_id = register_id;
		this.name = name;
		this.author = author;
		this.author_name = author_name;
		this.register_date = register_date;
		this.finish_date = finish_date;
		this.property = property;
		this.category_id = category_id;
		this.development_mode = development_mode;
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

	public String getRegister_id() {
		return register_id;
	}

	public void setRegister_id(String register_id) {
		this.register_id = register_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getDevelopment_mode() {
		return development_mode;
	}

	public void setDevelopment_mode(String development_mode) {
		this.development_mode = development_mode;
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
