package com.jialin.dao;

import java.util.List;

import com.jialin.basedao.BaseDao;
import com.jialin.entity.Population;

public interface IPopulationDao extends BaseDao<Population> {
	
	public List<Population> findByIds(int[] s );
}
