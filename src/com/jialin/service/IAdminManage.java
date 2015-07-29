package com.jialin.service;

import com.jialin.entity.Admin;

public interface IAdminManage {
	public boolean CheckLogin(Admin admin);
	public  void ChangePassword(String username,String newPassword);
	public  Admin GetAdmin(String username);
	public String getErrMessage();
}
