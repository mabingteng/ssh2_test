package com.jialin.dao;

import java.util.List;

import com.jialin.basedao.BaseDaoImp;
import com.jialin.entity.Population;
@SuppressWarnings("unchecked")
public class UserPopulationDaoImp extends BaseDaoImp<Population> implements IUserPopulationDao {

    
    @Override
    public List<Population> findByIds(int[] ids) {
	// TODO 自动生成的方法存根
	
	return  (List<Population>)getSession().//
		createQuery("from Population Where id in (:ids)").//
		setParameter("ids",ids).list();
    }

	
	


}
