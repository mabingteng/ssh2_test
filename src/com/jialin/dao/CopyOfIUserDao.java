package com.jialin.dao;

import com.jialin.entity.User;

public interface CopyOfIUserDao {
	public void AddUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
}
