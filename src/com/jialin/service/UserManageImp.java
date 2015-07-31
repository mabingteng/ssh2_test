package com.jialin.service;

import java.util.List;

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

	@Override
	public List<User> getUserList() {
	    // TODO 自动生成的方法存根
	    List<User> li= userDao.findAll();
	    return li;
	}

	@Override
	public User getByAccountName(String acname) {
	    // TODO 自动生成的方法存根
	    return userDao.getByAccountName(acname);
	}

	@Override
	public User getById(long id) {
	    // TODO 自动生成的方法存根
	    User u = userDao.getbyId(id);
	    return u;
	}

	@Override
	public List<User> getByHql(String hql) {
	    // TODO 自动生成的方法存根
	    return userDao.getByHql(hql);
	}

	@Override
	public String findUserByAccountnameAndPassword(String accountName, String password) {
	    // TODO 自动生成的方法存根
	    String hql="from User where accountName ='"+accountName+"' and password = '"+password+"' and deleteMark = 1 and status = 'ON'";
	    List<User> uList =   userDao.getByHql(hql);
	    if(uList!=null&&uList.size()!=0){
		User u = uList.get(0);
		return u.getUserType();
	    }
	    return null;
	}
}
