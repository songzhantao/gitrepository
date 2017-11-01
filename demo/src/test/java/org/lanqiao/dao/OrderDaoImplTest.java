package org.lanqiao.dao;

import org.junit.Assert;
import org.junit.Test;
import org.lanqiao.base.BaseJunit4Test;
import org.lanqiao.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderDaoImplTest   extends  BaseJunit4Test{

	

	@Autowired
	UserDao   userDao;
	
	
	@Test
	public void loginTest(){
		User user =userDao.login("admin", "1234567");
		Assert.assertNotNull( user);
	}
}
