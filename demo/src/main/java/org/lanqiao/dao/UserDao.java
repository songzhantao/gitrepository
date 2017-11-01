package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.model.Dept;
import org.lanqiao.model.User;
import org.lanqiao.vo.UserVo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	public User  login(String uname ,String upass);
	public User  login1(@Param ("uname") String uname ,@ Param ("upass") String upass);
	
	public   List findList();
	public User  findById(String id);
	public void  insertUser(User user);
	
	public List findBySearch(UserVo vo);
	public  Dept findDeptById(String id);
	public  void  deleteUsers(String  [] ids);
	
	@Delete("delete  from User  where id =#{id}")
	public void deleteUserById(String id);
}
