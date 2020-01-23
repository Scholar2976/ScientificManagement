/**
 * 用来格式化应答报文
 * 
 */
package com.ccb.sm.response;

import com.ccb.sm.util.ObjectTransformJson;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseMessageObject {

	
	private String C_API_Status;

	// 应答报文描述
	
	private String C_Response_Desc;

	// 应答报文报文体

	private Object C_Response_Body;

	// 应答报文错误代码
	
	private String C_Response_Code;

	@JsonProperty("C-API-Status")
	public void setC_API_Status(String c_API_Status) {
		C_API_Status = c_API_Status;
	}
	@JsonProperty("C-Response-Desc")
	public void setC_Response_Desc(String c_Response_Desc) {
		C_Response_Desc = c_Response_Desc;
	}
	@JsonProperty("C-Response-Body")
	public void setC_Response_Body(Object c_Response_Body) {
		C_Response_Body = c_Response_Body;
	}
	@JsonProperty("C-Response-Code")
	public void setC_Response_Code(String c_Response_Code) {
		C_Response_Code = c_Response_Code;
	}

	@JsonProperty("C-API-Status")
	public String getC_API_Status() {
		return C_API_Status;
	}
	@JsonProperty("C-Response-Desc")
	public String getC_Response_Desc() {
		return C_Response_Desc;
	}
	@JsonProperty("C-Response-Body")
	public Object getC_Response_Body() {
		return C_Response_Body;
	}
	@JsonProperty("C-Response-Code")
	public String getC_Response_Code() {
		return C_Response_Code;
	}

	/**
	 * 获取生成的Json报文
	 * 
	 * @param obj
	 *            需要解析为json格式的对象
	 * @return json字符串
	 */
	public String getResponseMessage(Object obj) {
		String rmjson = ObjectTransformJson.getJsonResult(obj);
	/*	String formatJson = rmjson.replace("c_API_Status", "C-API-Status").replace("c_Response_Desc", "C-Response-Desc")
				.replace("c_Response_Body", "C-Response-Body").replace("c_Response_Code", "C-Response-Code");*/
		return rmjson;
	}
}
