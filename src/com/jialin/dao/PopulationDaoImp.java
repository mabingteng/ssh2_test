package com.jialin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jialin.entity.Population;

public class PopulationDaoImp implements IPopulationDao {

	
	private SessionFactory sessionfactory;
	

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	public Session getSession(){
		return sessionfactory.getCurrentSession();
	}

	@Override
	public void addPersion(Population p) {
		// TODO Auto-generated method stub
		getSession().save(p);

	}

	@Override
	public void deletePersion(Population p) {
		// TODO Auto-generated method stub
		getSession().delete(p);
	}

	@Override
	public void modifyPersion(Population p) {
		// TODO Auto-generated method stub
		getSession().update(p);

	}

	@Override
	public Population findPersionById(int id) {
		// TODO Auto-generated method stub
		
		return (Population) getSession().get(Population.class, id);
	}

	@Override
	public List<Population> getPersionList() {
		// TODO Auto-generated method stub
		String sql = "from Population";
		Query que = getSession().createQuery(sql);
		List<Population> list = que.list();
		return list;
	}


}
