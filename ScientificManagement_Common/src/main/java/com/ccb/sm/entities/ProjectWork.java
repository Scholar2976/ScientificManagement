package com.ccb.sm.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectWork {
	
	private int id;

	// 类别
	private String category;

	// 主编
	private String chief_editor;

	// 主编姓名
	private String chief_editor_name;

	// 创建时间
	private Date created_time;

	// 删除状态
	private boolean deleted;

	// 删除时间
	private Date deleted_time;

	// 领域分类
	private String domain_catetory;

	// 是否翻著
//	@JsonProperty("is_translation")
	@JsonIgnore
	private boolean is_translation;

	// 书号
	private String isbn;

	// 更新时间
	private Date modified_time;

	// 出版社/出版单位
	private String press;

	// 出版时间
	private Date publish_date;

	// 发行范围
	private String  publish_range;

	// 名称
	private String title;

	// 总字数(千字)
	private int wordnum;


	public ProjectWork() {
		super();
	}

	public ProjectWork(int id, String category, String chief_editor, String chief_editor_name, Date created_time,
			boolean deleted, Date deleted_time, String domain_catetory, boolean is_translation, String isbn,
			Date modified_time, String press, Date publish_date, String publish_range, String title, int wordnum) {
		super();
		this.id = id;
		this.category = category;
		this.chief_editor = chief_editor;
		this.chief_editor_name = chief_editor_name;
		this.created_time = created_time;
		this.deleted = deleted;
		this.deleted_time = deleted_time;
		this.domain_catetory = domain_catetory;
		this.is_translation = is_translation;
		this.isbn = isbn;
		this.modified_time = modified_time;
		this.press = press;
		this.publish_date = publish_date;
		this.publish_range = publish_range;
		this.title = title;
		this.wordnum = wordnum;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getChief_editor() {
		return chief_editor;
	}

	public void setChief_editor(String chief_editor) {
		this.chief_editor = chief_editor;
	}

	public String getChief_editor_name() {
		return chief_editor_name;
	}

	public void setChief_editor_name(String chief_editor_name) {
		this.chief_editor_name = chief_editor_name;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
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

	public String getDomain_catetory() {
		return domain_catetory;
	}

	public void setDomain_catetory(String domain_catetory) {
		this.domain_catetory = domain_catetory;
	}

	public boolean isIs_translation() {
		return is_translation;
	}

	public void setIs_translation(boolean is_translation) {
		this.is_translation = is_translation;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getModified_time() {
		return modified_time;
	}

	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getPublish_range() {
		return publish_range;
	}

	public void setPublish_range(String publish_range) {
		this.publish_range = publish_range;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWordnum() {
		return wordnum;
	}

	public void setWordnum(int wordnum) {
		this.wordnum = wordnum;
	}

}
