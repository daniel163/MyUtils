package com.handbb.ssp.service.impl;

import org.springframework.stereotype.Service;

import com.handbb.ssp.model.UserInfo;
import com.handbb.ssp.service.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	public UserInfo getUserInfobyID(Integer userid) {
		UserInfo userinfo = new UserInfo();
		userinfo.setId(userid);
		userinfo.setUsername("zhangheng");
		userinfo.setPassword("123");
		userinfo.setAge(28);
		return userinfo;
	}

}
