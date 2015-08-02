package com.jialin.service;

import java.util.List;

import com.jialin.entity.Category;


public interface ICategoryService {
	public void add(Category c);
	public void update(Category user);
	public void del(Category user);
	public List<Category> getCategoryList();
	public Category getById(long id);
	public List<Category> getByHql(String hql);
	public String getMenuList();
	public String getTreeMenuList(String type);
	public void executeHql(String hql);
}
