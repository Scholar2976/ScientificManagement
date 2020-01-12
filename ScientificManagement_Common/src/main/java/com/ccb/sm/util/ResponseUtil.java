package com.ccb.sm.util;

import com.ccb.sm.response.ResponseMessageObject;

public class ResponseUtil 
{
	public static String getResponseMess(String C_API_Status, String C_Response_Code, Object obj, String C_Response_Desc) {
		ResponseMessageObject rm = new ResponseMessageObject();
		rm.setC_API_Status(C_API_Status);
		rm.setC_Response_Code(C_Response_Code);
		rm.setC_Response_Body(obj);
		rm.setC_Response_Desc(C_Response_Desc);
		String formatJson = ObjectTransformJson.getJsonResult(rm);
		return formatJson;
	}


}
