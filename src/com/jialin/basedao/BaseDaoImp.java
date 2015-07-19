package com.jialin.basedao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
@SuppressWarnings("unchecked")
public abstract  class BaseDaoImp<T> implements BaseDao<T> {

    
    private SessionFactory sessionfactory;
    private Class<T> clazz;
    
  
    public  BaseDaoImp(){
	ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
	clazz = (Class<T>)pt.getActualTypeArguments()[0];
	System.out.println("---> clazz = " + clazz);
    }
    
    public SessionFactory getSessionfactory() {
        return sessionfactory;
    }

    public void setSessionfactory(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }
    
    protected Session getSession(){
	
	return sessionfactory.getCurrentSession();
    }

    @Override
    public void add(T t) {
	// TODO 自动生成的方法存根
	
	getSession().save(t);
    }

    @Override
    public void delete(T t) {
	// TODO 自动生成的方法存根
	getSession().delete(t);
	
    }

    @Override
    public void update(T t) {
	// TODO 自动生成的方法存根
	getSession().update(t);
    }

    @Override
    public List<T> findAll() {
	// TODO 自动生成的方法存根	
	return getSession().createQuery("from "+clazz.getSimpleName()).list();
	
    }

    @Override
    public T getbyId(int id) {
	// TODO 自动生成的方法存根
	return (T) getSession().get(clazz, id);
    }
    
    
}
