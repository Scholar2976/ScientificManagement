package com.ccb.sm.entities;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectWork {
	// id
	private Integer id;

	// 书号
	private String isbn;

	// 名称
	private String title;

	// 类别 (参数名：workCategoryType)
	private String category;

	// 出版社/出版单位
	private String press;

	// 出版时间
	private Date publish_date;

	// 总字数(千字)
	private Integer wordnum;

	// 是否翻著
	private char is_translation;

	// 主编
	private String chief_authors;

	// 副主编
	private String deputy_authors;

	// 编著人员
	private String members;

	// 编著单位
	private String units;

	// 发行范围 (参数名：workRangType)
	private String publish_range;

	// 领域分类 (参数名：classification)
	private String domain;

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
	private Boolean deleted;

	// 删除时间
	private Date deleted_time;

	public ProjectWork() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectWork(Integer id, String isbn, String title, String category, String press, Date publish_date,
			Integer wordnum, char is_translation, String chief_authors, String deputy_authors, String members,
			String units, String publish_range, String domain, String creator, String modifier, String deleter,
			Date created_time, Date modified_time, Boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.category = category;
		this.press = press;
		this.publish_date = publish_date;
		this.wordnum = wordnum;
		this.is_translation = is_translation;
		this.chief_authors = chief_authors;
		this.deputy_authors = deputy_authors;
		this.members = members;
		this.units = units;
		this.publish_range = publish_range;
		this.domain = domain;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Integer getWordnum() {
		return wordnum;
	}

	public void setWordnum(Integer wordnum) {
		this.wordnum = wordnum;
	}

	public char getIs_translation() {
		return is_translation;
	}

	public void setIs_translation(char is_translation) {
		this.is_translation = is_translation;
	}

	public String getChief_authors() {
		return chief_authors;
	}

	public void setChief_authors(String chief_authors) {
		this.chief_authors = chief_authors;
	}

	public String getDeputy_authors() {
		return deputy_authors;
	}

	public void setDeputy_authors(String deputy_authors) {
		this.deputy_authors = deputy_authors;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getPublish_range() {
		return publish_range;
	}

	public void setPublish_range(String publish_range) {
		this.publish_range = publish_range;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
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
