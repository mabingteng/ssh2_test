package com.jialin.dao;

import java.util.List;

import com.jialin.entity.Population;

public interface IPopulationDao {
	
	public void deletePersion(Population p);
	public void modifyPersion(Population p);
	public Population findPersionById(int id);
	public List<Population> getPersionList();
	void addPersion(Population p);
}
