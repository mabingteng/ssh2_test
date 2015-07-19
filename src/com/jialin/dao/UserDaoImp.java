package com.jialin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jialin.basedao.BaseDaoImp;
import com.jialin.entity.User;

public class UserDaoImp extends BaseDaoImp<User> implements IUserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	

}
