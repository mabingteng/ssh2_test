package com.jialin.dao;

import com.jialin.basedao.BaseDao;
import com.jialin.entity.User;

public interface IUserDao extends BaseDao<User> {
	public User getByAccountName(String acname);
}
