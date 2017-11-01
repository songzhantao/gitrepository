package org.lanqiao.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.lanqiao.base.BaseJunit4Test;
import org.lanqiao.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImplTest  extends  BaseJunit4Test{

	@Autowired
	UserDao   userDao;
	
	
	@Test
	public void loginTest(){
		User user =userDao.login("admin", "123456");
		Assert.assertNotNull(user);
	}
	
	
	@Test
	public void  findListTest(){
		List<User>  list =userDao.findList();
		Assert.assertEquals(list.size(), 1);
	}
	
}
