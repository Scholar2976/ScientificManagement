package com.hospital301.scientificmanagement.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;



public class WebFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

    @Override
    @Order(Integer.MAX_VALUE-1)
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		

		response.setHeader("Access-Control-Allow-Origin","*");

		response.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE");

		response.setHeader("Access-Control-Allow-Headers","c-app-id,c-business-id,c-dynamic-password-foruser,c-tenancy-id,c-timestamp,content-type");

		response.setHeader("Allow","POST");
		/*//跨域请求，*代表允许全部类型
		response.setHeader("Access-Control-Allow-Origin", "*");
		//允许请求方式
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		//用来指定本次预检请求的有效期，单位为秒，在此期间不用发出另一条预检请求
		response.setHeader("Access-Control-Max-Age", "3600");
		//请求包含的字段内容，如有多个可用哪个逗号分隔如下c-app-id,c-business-id,c-dynamic-password-foruser,c-tenancy-id,c-timestamp,content-type
		response.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,Authorization, x-ui-request,lang");
		//访问控制允许凭据，true为允许
		response.setHeader("Access-Control-Allow-Credentials", "true");*/
		// 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
        // 配置options的请求返回
		if (request.getMethod().equals("OPTIONS")) {
	//		response.setStatus(HttpStatus.OK_200);
			response.getWriter().write("OPTIONS returns OK");
			return;
		}		
		// 传递业务请求处理
		chain.doFilter(servletRequest, servletResponse);
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
