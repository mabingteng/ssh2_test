package com.jialin.service;

import java.util.List;

import javax.annotation.Resource;

import com.jialin.dao.IPopulationDao;
import com.jialin.entity.Population;

public class PopulationManagerImp implements IPopulationManage {

	@Resource
	private IPopulationDao pDao;
	
	public IPopulationDao getDao(){
		return this.pDao;
	}
	
	@Override
	public void addPersion(Population p) {
		// TODO Auto-generated method stub
		pDao.addPersion(p);
	}

	@Override
	public void deletePersion(Population p) {
		// TODO Auto-generated method stub
		pDao.deletePersion(p);
	}

	@Override
	public void modifyPersion(Population p) {
		// TODO Auto-generated method stub
		pDao.modifyPersion(p);
	}

	@Override
	public Population findPersionById(int id) {
		// TODO Auto-generated method stub
		
		return pDao.findPersionById(id);
	}

	@Override
	public List<Population> getPersionList() {
		// TODO Auto-generated method stub
		return  pDao.getPersionList();
	}

}
