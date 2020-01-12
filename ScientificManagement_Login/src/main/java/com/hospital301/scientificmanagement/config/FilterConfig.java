package com.hospital301.scientificmanagement.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hospital301.scientificmanagement.Filter.TokenFilter;
import com.hospital301.scientificmanagement.Filter.WebFilter;



@Configuration
public class FilterConfig 
{
	/**
	 * 用来处理跨域访问 问题
	 * @return
	 */
	@Bean
	public FilterRegistrationBean WebFilterBean() {
         FilterRegistrationBean registrationBean = new FilterRegistrationBean();
          registrationBean.setFilter(new WebFilter());
          registrationBean.addUrlPatterns("/*");
          registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/reg");
          registrationBean.setOrder(1);
          return registrationBean;
    }

	@Bean
	public FilterRegistrationBean tokenFilterBean() {
         FilterRegistrationBean registrationBean = new FilterRegistrationBean();
          registrationBean.setFilter(setTokenFilter());
          registrationBean.addUrlPatterns("/*");
          registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/reg");
          registrationBean.setOrder(2);
          return registrationBean;
    }
	@Bean
	public TokenFilter setTokenFilter()
	{
		return new TokenFilter();
	}
}
