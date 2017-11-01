package org.lanqiao.model;

import java.util.List;

/**
 * 关联关系配置
 * @author Administrator
 *
 */
public class Dept {
	
	String deptId;
	String deptName;
	//一对多
	List<User> users;

	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}
