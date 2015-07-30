package com.jialin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jialin.basedao.BaseDaoImp;
import com.jialin.entity.User;
@SuppressWarnings("unchecked")
public class UserDaoImp extends BaseDaoImp<User> implements IUserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User getByAccountName(String acname) {
	    // TODO 自动生成的方法存根
	    String hql = " from User  where accountName = '"+ acname+"'";
	    Query query = getSession().createQuery(hql);
	   
	    List<User> list =  query.list();
	    if(list!=null && list.size()!=0){
		return  (User)list.get(0);
	    }
    	    return null;
	}

	

}
