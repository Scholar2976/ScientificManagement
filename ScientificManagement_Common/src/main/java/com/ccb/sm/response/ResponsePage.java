/**
 * 此类用于分页查询结果
 */
package com.ccb.sm.response;

import java.util.HashMap;
import java.util.Map;

public class ResponsePage 
{
	private Object list;
	
	private  Map <String,Object> txnCommCom = new HashMap();

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public Map<String, Object> getTxnCommCom() {
		return txnCommCom;
	}

	public void setTxnCommCom(Map<String, Object> txnCommCom) {
		this.txnCommCom = txnCommCom;
	}

	

}
