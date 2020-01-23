package com.hospital301.scientificmanagement.Filter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccb.sm.util.ResponseUtil;
import com.ccb.sm.util.StatusCode;
import com.hospital301.scientificmanagement.Redis.Redis;

/** 
* @author 作者 
* @version 创建时间：2020年1月8日 下午5:12:12 
* 类说明 
*/

public class TokenFilter implements Filter {

	@Resource
	private Redis redis;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		if(!request.getRequestURI().endsWith("/login"))
		{
			String tokenId=request.getHeader("C-Dynamic-Password-Foruser");
			if(null == tokenId || tokenId.length() == 0)
			{
				
				String jsonstr = ResponseUtil.getResponseMess(StatusCode.C_API_Status_FAILURE, StatusCode.TOKENERROR,
						"[ERRORCODE="+StatusCode.TOKENERROR+"][TOKEN为空]",
						StatusCode.C_Response_Desc_FAILURE);
				response.getWriter().write(jsonstr);
				return;
			}
			long flag =redis.isExpire("token:"+tokenId);
//			long flag =redis.isExpire("token:"+tokenId);
			if(flag == -2)
			{
				String jsonstr = ResponseUtil.getResponseMess(StatusCode.C_API_Status_FAILURE, StatusCode.TOKENERROR,
						"[ERRORCODE="+StatusCode.TOKENERROR+"][TOKEN不存在]",
						StatusCode.C_Response_Desc_FAILURE);
				response.getWriter().write(jsonstr);
				return;
			}
			if(flag == -1)
			{
				String jsonstr = ResponseUtil.getResponseMess(StatusCode.C_API_Status_FAILURE, StatusCode.TOKENERROR,
						"[ERRORCODE="+StatusCode.TOKENERROR+"][TOKEN过期]",
						StatusCode.C_Response_Desc_FAILURE);
				response.getWriter().write(jsonstr);
				return;
			}
			redis.expireKey("token:"+tokenId, 60*30, TimeUnit.SECONDS);
			servletRequest.setAttribute("user", redis.get("token:"+tokenId));
		}
		
		chain.doFilter(servletRequest, servletResponse);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
