package com.jialin.service;

import java.util.List;

import com.jialin.entity.Population;
import com.jialin.entity.User;

public interface IUserManage {
	public void addUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public List<User> getUserList();
	public User getByAccountName(String acname);
	public User getById(long id);
	public List<User> getByHql(String hql);
	public String findUserByAccountnameAndPassword(String accountName , String password);
}
