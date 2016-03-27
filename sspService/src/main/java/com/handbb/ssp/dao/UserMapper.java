package com.handbb.ssp.dao;

import java.util.List;

import com.handbb.ssp.model.User;

/***
 * mapper����ӿ�
 * @author zhangheng
 *
 */
public interface UserMapper {
	
	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User findUserById(Integer id) throws Exception;
	
	/**
	 * ����name��ѯ�û���Ϣ�б�
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<User> findUserByName(String name) throws Exception;
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @throws Exception
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * ����idɾ���û���Ϣ
	 * @param id
	 * @throws Exception
	 */
	public void deleteUserById(int id) throws Exception;
	
	/**
	 * ����id�����û���Ϣ
	 * @param id
	 * @throws Exception
	 */
	public void updateUserById(int id) throws Exception;
	
	
	
	
	

}
