package com.hospital301.scientificmanagement.services.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccb.sm.entities.User;
import com.ccb.sm.util.JsonUtil;
import com.hospital301.scientificmanagement.dao.user.UserDao;
import com.hospital301.scientificmanagement.services.user.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserDao userDao;
	
	@Override
	public String searchUser(String username) {
		List list = new ArrayList();
		List<User> userlist = userDao.QueryByLike(username);
		for(User user : userlist)
		{
			Map map = new HashMap();
			map.put("value",user.getUsername());
			map.put("label", user.getNickname());
			map.put("organization_id", user.getOrganization_id());
			map.put("organization_name", user.getOrganization_name());
			map.put("rank",user.getRank());
			list.add(map);
		}
		return JsonUtil.getJsonResult(list);
	}
	
}
