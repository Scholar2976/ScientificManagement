package com.hospital301.scientificmanagement.controller.util;
/** 
* @author 作者 
* @version 创建时间：2020年1月7日 下午2:07:49 
* 类说明 
*/
public enum TableNameEnum 
{
	PARAMETER("parameter"),
	PARAMETERVALUE("parameter_value"),
	PROJECTPATENT("project_patent"),
	PROJECTPAPER("project_paper"),
	PROJECTLAB("project_lab"),
	PROJECT("project"),
	PROJECTREWARD("project_reward"),
	PROJECTSOFTWARE("project_software"),
	PROJECTUNIT("project_unit"),
	PROJECTWORK("project_work"),
	PROJECTMEMBER("project_member"),
	PROJECTKEYWORD("project_keyword"),
	PROJECTACADEMY("project_academy"),
	PROJECTACADEMYPOST("project_academy_post"),
	PROJECTATTACHMENT("project_attachment"),
	PROJECTCOOPERATION("project_cooperation"),
	PROJECTEQUIPMENT("project_equipment"),
	PROJECTEXCHANGE("project_exchange"),
	PROJECTFUND("project_fund"),
	PROJECTLABTECHNIQUE("project_lab_technique"),
	PROJECTREGULATION("project_regulation"),
	PROJECTRELATIONREL("project_relation_rel"),
	MENU("menu");
	
	private String name;
	private TableNameEnum(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
}
