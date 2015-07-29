package com.jialin.service;

import javax.annotation.Resource;

import com.jialin.dao.IAdminDao;
import com.jialin.dao.IPopulationDao;
import com.jialin.entity.Admin;

public class AdminManagerImp implements IAdminManage {
	@Resource
	private IAdminDao aDao;
	
    	

	public IAdminDao getaDao() {
		return aDao;
	}

	public void setaDao(IAdminDao aDao) {
		this.aDao = aDao;
	}

	@Override
	public void ChangePassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		aDao.ChangePassword(username, newPassword);
	}

	@Override
	public Admin GetAdmin(String username) {
		// TODO Auto-generated method stub
		return aDao.GetAdmin(username);
	}

	@Override
	public String getErrMessage() {
		// TODO Auto-generated method stub
		return aDao.getErrMessage();
	}

	@Override
	public boolean CheckLogin(Admin admin) {
		// TODO Auto-generated method stub
		
		return aDao.CheckLogin(admin);
	}
	
	
	
	
}
