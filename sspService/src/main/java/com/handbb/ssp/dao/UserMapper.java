package com.handbb.ssp.dao;

import java.util.List;

import com.handbb.ssp.model.User;

/***
 * mapper代理接口
 * @author zhangheng
 *
 */
public interface UserMapper {
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findUserById(Integer id) throws Exception;
	
	/**
	 * 根据name查询用户信息列表
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<User> findUserByName(String name) throws Exception;
	
	/**
	 * 插入用户信息
	 * @param user
	 * @throws Exception
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * 根据id删除用户信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserById(int id) throws Exception;
	
	/**
	 * 根据id更新用户信息
	 * @param id
	 * @throws Exception
	 */
	public void updateUserById(int id) throws Exception;
	
	
	
	
	

}
