package com.jialin.service;

import java.util.List;

import javax.annotation.Resource;

import com.jialin.dao.IUserPopulationDao;
import com.jialin.entity.Population;

public class UserPopulationManagerImp implements IUserPopulationManage {

	@Resource
	private IUserPopulationDao userpDao;
	
	public IUserPopulationDao getDao(){
		return this.userpDao;
	}
	
	@Override
	public void addPersion(Population p) {
		// TODO Auto-generated method stub
	    userpDao.add(p);
	}

	@Override
	public void deletePersion(Population p) {
		// TODO Auto-generated method stub
	    userpDao.delete(p);
	}

	@Override
	public void modifyPersion(Population p) {
		// TODO Auto-generated method stub
		userpDao.update(p);
	}

	@Override
	public Population findPersionById(int id) {
		// TODO Auto-generated method stub
		
		return userpDao.getbyId(id);
	}

	@Override
	public List<Population> getPersionList() {
		// TODO Auto-generated method stub
		return  userpDao.findAll();
	}

}
