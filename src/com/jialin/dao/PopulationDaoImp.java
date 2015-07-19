package com.jialin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jialin.basedao.BaseDaoImp;
import com.jialin.entity.Population;
@SuppressWarnings("unchecked")
public class PopulationDaoImp extends BaseDaoImp<Population> implements IPopulationDao {

    
    @Override
    public List<Population> findByIds(int[] s) {
	// TODO 自动生成的方法存根
	
	return  (List<Population>)getSession().createQuery("from Population Where id in (:ids)").list();
    }

	
	


}
