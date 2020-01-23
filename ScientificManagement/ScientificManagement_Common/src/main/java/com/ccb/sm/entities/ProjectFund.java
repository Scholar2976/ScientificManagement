package com.ccb.sm.entities;

import java.util.Date;

/** 
* @author 作者 
* @version 创建时间：2019年12月30日 下午4:05:49 
* 类说明  (项目经费明细表) 
*/
public class ProjectFund 
{
	//id  
	private Integer id;      
	//所属项目  
	private Integer project_id;
	//年  
	private Integer year;    
	//当年拨入经费 
	private Integer in_fund;    
	//当年支出经费  
	private Integer out_fund;    
	//当年支出经费中内部支出 
	private Integer out_inner;    
	//设备费  
	private Integer out_equipment;    
	//其它  
	private Integer out_other;   
	//当年支出经费中外部支出  
	private Integer out_outer;
	//军队  
	private Integer out_army;  
	//军工  
	private Integer  out_military_industry;   
	//民口  
	private Integer out_people; 
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
	
	public ProjectFund() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectFund(Integer id, Integer project_id, Integer year, Integer in_fund, Integer out_fund,
			Integer out_inner, Integer out_equipment, Integer out_other, Integer out_outer, Integer out_army,
			Integer out_military_industry, Integer out_people, String creator, String modifier, String deleter,
			Date created_time, Date modified_time, Boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.project_id = project_id;
		this.year = year;
		this.in_fund = in_fund;
		this.out_fund = out_fund;
		this.out_inner = out_inner;
		this.out_equipment = out_equipment;
		this.out_other = out_other;
		this.out_outer = out_outer;
		this.out_army = out_army;
		this.out_military_industry = out_military_industry;
		this.out_people = out_people;
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

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getIn_fund() {
		return in_fund;
	}

	public void setIn_fund(Integer in_fund) {
		this.in_fund = in_fund;
	}

	public Integer getOut_fund() {
		return out_fund;
	}

	public void setOut_fund(Integer out_fund) {
		this.out_fund = out_fund;
	}

	public Integer getOut_inner() {
		return out_inner;
	}

	public void setOut_inner(Integer out_inner) {
		this.out_inner = out_inner;
	}

	public Integer getOut_equipment() {
		return out_equipment;
	}

	public void setOut_equipment(Integer out_equipment) {
		this.out_equipment = out_equipment;
	}

	public Integer getOut_other() {
		return out_other;
	}

	public void setOut_other(Integer out_other) {
		this.out_other = out_other;
	}

	public Integer getOut_outer() {
		return out_outer;
	}

	public void setOut_outer(Integer out_outer) {
		this.out_outer = out_outer;
	}

	public Integer getOut_army() {
		return out_army;
	}

	public void setOut_army(Integer out_army) {
		this.out_army = out_army;
	}

	public Integer getOut_military_industry() {
		return out_military_industry;
	}

	public void setOut_military_industry(Integer out_military_industry) {
		this.out_military_industry = out_military_industry;
	}

	public Integer getOut_people() {
		return out_people;
	}

	public void setOut_people(Integer out_people) {
		this.out_people = out_people;
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
