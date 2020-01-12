/**
 * 用来存储返回给前台的错误报文报文体
 */

package com.ccb.sm.response;

public class ErrorResponseCommInfo 
{
    // 错误描述
	private String ErrorDescription ="后台查询数据为空，请联系管理人员";

	public String getErrorDescription() {
		return ErrorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		ErrorDescription = errorDescription;
	}
	
	
}
