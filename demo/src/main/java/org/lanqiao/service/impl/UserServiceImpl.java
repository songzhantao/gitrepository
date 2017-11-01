package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.annotaion.Slave;
import org.lanqiao.dao.UserDao;
import org.lanqiao.model.Dept;
import org.lanqiao.model.User;
import org.lanqiao.service.UserService;
import org.lanqiao.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao  userDao;
	
	
	
	//没有业务

	@Override
	public User login(String uname, String upass) {
		return userDao.login(uname,upass);
	}

	@Override
	public List findList() {
		return userDao.findList();
	}

	@Override
	public Dept findDeptById(String id) {
		return userDao.findDeptById(id);
	}

	@Override
	public List findBySearch(UserVo vo) {
		
		return userDao.findBySearch(vo);
	}

	@Override
	public void deleteUsers(String[] ids) {
		userDao.deleteUsers(ids);
		
	}

}
