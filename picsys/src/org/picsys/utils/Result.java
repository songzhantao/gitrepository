package org.picsys.utils;

public class Result {
	private  String  flag;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private  String  msg;
	
	
	public Result(String flag,String msg){
		this.flag=flag;
		this.msg=msg;
		
	}
	
}
