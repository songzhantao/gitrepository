package org.lanqiao.service;

import java.util.List;

import org.lanqiao.model.Dept;
import org.lanqiao.model.User;
import org.lanqiao.vo.UserVo;

public interface UserService {

	public User login(String uname,String upass);
	public List findList();
	public Dept findDeptById(String id);
	public List findBySearch(UserVo vo); 
	public  void  deleteUsers(String  []ids);
}
