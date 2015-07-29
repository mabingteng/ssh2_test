package com.jialin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jialin.entity.Population;

public class PopulationDaoImp implements IPopulationDao {
    private int PAGE_SIZE=10;
    private int totalPage;
    private int recordNumber;
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

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

	@Override
	public List<Population> QueryPopulationClassInfo(int currentPage) {
		// TODO Auto-generated method stub
		String sql="From Population population where 1=1";
		Query que=getSession().createQuery(sql);
		int StartIndex=(currentPage-1)*this.PAGE_SIZE;
		que.setFirstResult(StartIndex);
		que.setMaxResults(this.PAGE_SIZE);
		List<Population> populationLsit=que.list();
		return populationLsit;
	}

	@Override
	public void CalculateTotalPageAndRecordNumber() {
		// TODO Auto-generated method stub
		String  hql="From Population population Where 1=1";
		Query que=getSession().createQuery(hql);
		List<Population> populationLsit=que.list();
		recordNumber=populationLsit.size();
		int mod=recordNumber%this.PAGE_SIZE;
		totalPage=recordNumber/this.PAGE_SIZE;
		if(mod!=0)totalPage++;
		
	}

	@Override
	public List<Population> getALLPersonLsit(String sql) {
		Query que = getSession().createQuery(sql);
		List<Population> list = que.list();
		return list;
	}


}
