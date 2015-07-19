package com.jialin.service;

import java.util.List;

import com.jialin.entity.Population;

public interface IPopulationManage {
   public void addPersion(Population p);
	public void deletePersion(Population p);
	public void modifyPersion(Population p);
	public Population findPersionById(int id);
	public List<Population> getPersionList();
}
