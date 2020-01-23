package com.hospital301.scientificmanagement.controller.util;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ccb.sm.entities.User;
import com.hospital301.scientificmanagement.Redis.Redis;

/** 
* @author 作者 
* @version 创建时间：2020年1月13日 上午10:01:55 
* 类说明 
*/
@Component
public class RedisUtil implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	@Override
	public  void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
	
	  /**
     * 通过class获取Bean.
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }
    
	public static  User getRedisUserInfo(String tokenid)
	{
		Redis redis = getBean(Redis.class);
		if(redis.existsKey("token:"+tokenid))
		{
			return (User) redis.get("token:"+tokenid);
		}
		return null;
	}

}
