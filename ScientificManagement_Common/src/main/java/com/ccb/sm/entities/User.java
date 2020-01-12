package com.ccb.sm.entities;

import java.util.Date;

public class User {
	 //id  
	private Integer id ;      
	//用户编号  
	private String username;      
	//拼音  
	private String pinyin;    
	//邮箱  
	private String email;    
	//电话  
	private String telphone;    
	//手机  
	private String mobile;    
	//password  
	private String password;    
	//头像  
	private String image;    
	//显示名称 
	private String nickname;    
	//生日  
	private Date birthday;    
	//性别  
	private String sex;    
	//学位  
	private String degree;    
	//学历  
	private String education;  
	//行政职务  
	private String administration_duty;    
	//研究方向  
	private String research_direction;    
	//其它方向  
	private String research_other;  
	//详细介绍  
	private String introduction;    
	//是否在编  
	private String is_establishment;    
	//职称  
	private String rank;
	//超级用户  
	private boolean is_superuser;    
	//上次登录时间  
	private Date last_login;   
	//所属部门  
	private String organization_id;
	//所属部门名称  
	private String organization_name;    
	//创建时间  
	private Date created_time;    
	//更新时间  
	private Date modified_time;    
	//删除状态  
	private boolean deleted;    
	//删除时间  
	private Date deleted_time;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String username, String pinyin, String email, String telphone, String mobile,
			String password, String image, String nickname, Date birthday, String sex, String degree, String education,
			String administration_duty, String research_direction, String research_other, String introduction,
			String is_establishment, String rank, boolean is_superuser, Date last_login, String organization_id,
			String organization_name, Date created_time, Date modified_time, boolean deleted, Date deleted_time) {
		super();
		this.id = id;
		this.username = username;
		this.pinyin = pinyin;
		this.email = email;
		this.telphone = telphone;
		this.mobile = mobile;
		this.password = password;
		this.image = image;
		this.nickname = nickname;
		this.birthday = birthday;
		this.sex = sex;
		this.degree = degree;
		this.education = education;
		this.administration_duty = administration_duty;
		this.research_direction = research_direction;
		this.research_other = research_other;
		this.introduction = introduction;
		this.is_establishment = is_establishment;
		this.rank = rank;
		this.is_superuser = is_superuser;
		this.last_login = last_login;
		this.organization_id = organization_id;
		this.organization_name = organization_name;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAdministration_duty() {
		return administration_duty;
	}

	public void setAdministration_duty(String administration_duty) {
		this.administration_duty = administration_duty;
	}

	public String getResearch_direction() {
		return research_direction;
	}

	public void setResearch_direction(String research_direction) {
		this.research_direction = research_direction;
	}

	public String getResearch_other() {
		return research_other;
	}

	public void setResearch_other(String research_other) {
		this.research_other = research_other;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIs_establishment() {
		return is_establishment;
	}

	public void setIs_establishment(String is_establishment) {
		this.is_establishment = is_establishment;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public boolean isIs_superuser() {
		return is_superuser;
	}

	public void setIs_superuser(boolean is_superuser) {
		this.is_superuser = is_superuser;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
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
