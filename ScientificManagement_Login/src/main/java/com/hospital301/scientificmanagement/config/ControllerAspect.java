package com.hospital301.scientificmanagement.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ccb.sm.response.ErrorResponseCommInfo;
import com.ccb.sm.util.JsonUtil;
import com.ccb.sm.util.ResponseUtil;
import com.ccb.sm.util.StatusCode;

@Component
@Aspect
public class ControllerAspect {
	
	private final String ExpGetResultDataPonit = "execution(* com.hospital301.scientificmanagement.controller..*.*(..))";

	@Pointcut(ExpGetResultDataPonit)
	public void excuteService() {}
	
	/**
	 * 
	 * 后置返回通知
	 * 
	 * 这里需要注意的是:
	 * 
	 * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
	 * 
	 * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
	 * 
	 * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
	 * 对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
	 * 
	 */

	@AfterReturning(value = ExpGetResultDataPonit, returning = "obj" ,pointcut ="excuteService()" )
	public void doAfterReturningAdvice1(JoinPoint joinPoint, Object obj) 
	{
		packResponseBody(obj);
	}
	

	/**
	 * 对controller层返回的报文体进行格式化
	 * @param obj controller层返回的数据
	 * @return
	 */
	public String packResponseBody(Object obj)
	{
		if(obj instanceof ErrorResponseCommInfo )
		{
			return ResponseUtil.getResponseMess(StatusCode.C_API_Status_FAILURE, StatusCode.C_Response_Code_FAILURE, obj,
					StatusCode.C_Response_Desc_FAILURE);
		}
		if(null != obj)
		{
			try {
				obj = JsonUtil.objectToJson(obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			obj="请求报文为空或数据库未查询到相关数据";
		}
		return ResponseUtil.getResponseMess(StatusCode.C_API_Status_SUCCESS, StatusCode.C_Response_Code_SUCCESS, obj,
				StatusCode.C_Response_Desc_SUCCESS);
	}

}
