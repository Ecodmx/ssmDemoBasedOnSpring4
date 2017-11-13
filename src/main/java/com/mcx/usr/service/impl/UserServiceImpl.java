package com.mcx.usr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mcx.usr.dao.UserDao;
import com.mcx.usr.entity.User;
import com.mcx.usr.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao<User> dao;
	
	public boolean doUserLogin(User user) {
		List<User> list = dao.selectId(user.getUsername());
		if(list.size() == 0){
			return false;
		}else{
			if(list.get(0).getPassword().equals(user.getPassword())){				
				return true;
			}else{
				return false;
			}			
		}
	}	

}
