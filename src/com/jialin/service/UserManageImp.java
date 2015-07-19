package com.jialin.service;

import javax.annotation.Resource;

import com.jialin.dao.IUserDao;
import com.jialin.entity.User;

public class UserManageImp implements IUserManage {
	
	@Resource  
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		System.out.println("------UserManageImp.adddUser--------"+user.getName());
		userDao.add(user);
		
	}

	@Override
	public void modifyUser(User user) {
		System.out.println("------UserManageImp.modifyUser--------"+user.getName());
		userDao.update(user);

	}

	@Override
	public void deleteUser(User user) {
		System.out.println("------UserManageImp.deleteUser--------"+user.getName());
		userDao.delete(user);
	}
}
