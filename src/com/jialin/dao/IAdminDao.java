package com.jialin.dao;

import com.jialin.action.*;
import com.jialin.entity.Admin;
public interface IAdminDao {
  
	//public boolean CheckLogin(Admin admin);
	public  void ChangePassword(String username,String newPassword);
	public  Admin GetAdmin(String username);
	public String getErrMessage();
	public boolean CheckLogin(Admin admin);
}
