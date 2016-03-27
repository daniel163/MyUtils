package sspService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.handbb.ssp.dao.UserMapper;
import com.handbb.ssp.model.User;

public class test01 {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("classpath:myApplicationContext.xml");
		UserMapper userDao = (UserMapper) ctx.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user);
	}
}
