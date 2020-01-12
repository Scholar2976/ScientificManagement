package com.ccb.sm.entities;

import java.util.Date;

/**
 * @author 作者
 * @version 创建时间：2019年12月27日 上午9:35:32 类说明 学术活动表
 */

public class ProjectExchange {
	// id
	private Integer id;
	// 名称
	private String name;
	// 级别
	private String level;
	// 活动类型 (参数名：exchangeType)
	private String type;
	// 活动类型其它
	private String type_other;
	// 交流方式 (参数名：exchangeMode)
	private String exchange_mode;
	// 开始日期
	private Date begin_date;
	// 截止日期
	private Date end_date;
	// 举办地点
	private String host_place;
	// 参加人数
	private Integer attend_numbe;
	// 主要内容
	private String desc;
	// 创建人
	private String creator;
	// 修改人
	private String modifier;
	// 删除人
	private String deleter;
	// 创建时间
	private Date created_time;
	// 更新时间
	private Date modified_time;
	// 删除状态
	private boolean deleted;
	// 删除时间
	private Date deleted_time;
	
	
	public ProjectExchange() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProjectExchange(Integer id, String name, String level, String type, String type_other, String exchange_mode,
			Date begin_date, Date end_date, String host_place, Integer attend_numbe, String desc, String creator,
			String modifier, String deleter, Date created_time, Date modified_time, boolean deleted,
			Date deleted_time) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.type = type;
		this.type_other = type_other;
		this.exchange_mode = exchange_mode;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.host_place = host_place;
		this.attend_numbe = attend_numbe;
		this.desc = desc;
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


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getType_other() {
		return type_other;
	}


	public void setType_other(String type_other) {
		this.type_other = type_other;
	}


	public String getExchange_mode() {
		return exchange_mode;
	}


	public void setExchange_mode(String exchange_mode) {
		this.exchange_mode = exchange_mode;
	}


	public Date getBegin_date() {
		return begin_date;
	}


	public void setBegin_date(Date begin_date) {
		this.begin_date = begin_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public String getHost_place() {
		return host_place;
	}


	public void setHost_place(String host_place) {
		this.host_place = host_place;
	}


	public Integer getAttend_numbe() {
		return attend_numbe;
	}


	public void setAttend_numbe(Integer attend_numbe) {
		this.attend_numbe = attend_numbe;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
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
