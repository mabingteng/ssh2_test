package com.jialin.dao;

import java.util.List;

import com.jialin.entity.Population;

public interface IPopulationDao {
	
	public void deletePersion(Population p);
	public void modifyPersion(Population p);
	public Population findPersionById(int id);
	public List<Population> getPersionList();
	public void   addPersion(Population p);
	public List<Population> QueryPopulationClassInfo(int currentPage);
	public void CalculateTotalPageAndRecordNumber();
	public List<Population> getALLPersonLsit(String sql);
}
