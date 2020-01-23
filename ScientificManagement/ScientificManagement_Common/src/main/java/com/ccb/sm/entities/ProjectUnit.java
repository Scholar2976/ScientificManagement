package com.ccb.sm.entities;

import java.util.Date;

import com.ccb.sm.util.JsonUtil;

public class ProjectUnit 
{
	/**
     * 主键
     */
    private Integer id;
    /**
     * 所属ID
     */
    private Integer reference_id;
    /**
     * 单位名称
     */
    private String name;
    /**
     * 关联类型
     */
    private String type;
    
    /**
     * 子关联类型
     */
    private String subtype;
    /**
     * 创建时间
     */
    private Date created_time;
    /**
     * 更新时间
     */
    private Date modified_time;
    /**
     * 删除标志
     */
    private Boolean deleted;
    /**
     * 删除时间
     */
    private Date deleted_time;
    

    
    public ProjectUnit() {
        super();
    }

    public ProjectUnit(Integer id, Integer reference_id, String name, String type, String subtype, Date created_time,
			Date modified_time, Boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.reference_id = reference_id;
		this.name = name;
		this.type = type;
		this.subtype = subtype;
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

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
    
    
}