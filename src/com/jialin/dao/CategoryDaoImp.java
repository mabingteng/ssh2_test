package com.jialin.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jialin.basedao.BaseDaoImp;
import com.jialin.entity.Category;

public class CategoryDaoImp extends BaseDaoImp<Category> implements ICategoryDao{
    private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
