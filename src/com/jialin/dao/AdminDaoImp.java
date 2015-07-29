package com.jialin.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jialin.entity.Admin;
import com.jialin.utils.HibernateUtil;

public class AdminDaoImp implements IAdminDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	private String errMessage;
	public String getErrMessage()
	{
		return this.errMessage;
	}
	public boolean CheckLogin(Admin admin) {
		Session s=null;
		try
		{
			s=HibernateUtil.getSession();
			 Admin db_admin=(Admin) getSession().get(Admin.class, admin.getACCOUNTNAME());
			  
			 if(db_admin==null)
			{
				this.errMessage="账号不存在";
				System.out.print(this.errMessage);
				return false;
			}
				
				else 
				
				if(!db_admin.getACCOUNTPASSWORD().equals(admin.getACCOUNTPASSWORD()))
					{
					   this.errMessage="密码不正确";
					   System.out.print(this.errMessage);
					   return false;
					}
			
		}finally
		{
			HibernateUtil.closeSession();
		}
	
	   return true;
	}

	@Override
	public void ChangePassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin GetAdmin(String username) {
		// TODO Auto-generated method stub
		Admin db_admin=null;
		db_admin=(Admin)getSession().get(Admin.class, username);
		return db_admin;		
		
	}

	
}
