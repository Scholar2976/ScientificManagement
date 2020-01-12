package com.hospital301.scientificmanagement.dao.user;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ccb.sm.entities.User;

@Mapper
public interface UserDao 
{
	public List<User> QueryByLike(String username);
}
