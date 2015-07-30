package com.jialin.service;

import java.util.List;

import javax.annotation.Resource;

import com.jialin.dao.ICategoryDao;
import com.jialin.entity.Category;

public class CategoryServiceImp implements ICategoryService {

    
    @Resource  
    private ICategoryDao cateDao;
    @Override
    public void add(Category c) {
	// TODO 自动生成的方法存根
	cateDao.add(c);

    }

    @Override
    public void update(Category c) {
	// TODO 自动生成的方法存根
	cateDao.update(c);
    }

    @Override
    public void del(Category c) {
	// TODO 自动生成的方法存根
	cateDao.delete(c);
    }

    @Override
    public List<Category> getCategoryList() {
	// TODO 自动生成的方法存根
	return cateDao.findAll();
    }

    @Override
    public Category getById(long id) {
	// TODO 自动生成的方法存根
	return cateDao.getbyId(id);
    }

    @Override
    public List<Category> getByHql(String hql) {
	// TODO 自动生成的方法存根
	return cateDao.getByHql(hql);
    }

    @Override
    public String getMenuList() {
	// TODO 自动生成的方法存根
	StringBuffer sb = new StringBuffer();
	//查管理员可见菜单，状态为ON 
	Category c = new Category();
	String hql1 = "from Category where ParentID ="+0 +"and Status = 'ON' and Check_Level = 2 and DeleteMark = '1' order by id ASC";
	List<Category> list1 = this.getByHql(hql1);
	if(list1.size()!=0){
	    System.out.println(list1.size());
	    for(int i1=0;i1<list1.size();i1++){
	       c = list1.get(i1);
	       sb.append("<li><a href=\"javascript:void(0)\"   onclick=\"$.bringBack({id:'"+c.getId()+"', districtName:'"+c.getName()+"'})\">"+c.getName()+"("+c.getCode()+")"+"</a>");
	       if(c.getDisLevel()==1){
		  sb =   getTree(sb,c.getId());
	       }else if (c.getDisLevel()==0)
	       {
	       	
	       sb.append("</li>");
	       }
	    }
	}
	return sb.toString();
    }
    
    private StringBuffer getTree(StringBuffer sb,long ParentID ){
	sb.append("<ul>");
	Category c = new Category();
	String Hql = "from Category where ParentID ="+ParentID +"and Status = 'ON' and Check_Level = 2 and DeleteMark = '1' order by id ASC";
	List<Category> list1 = this.getByHql(Hql);
	if(list1.size()!=0){
	    System.out.println(list1.size());
	    for(int i1=0;i1<list1.size();i1++){
	       c = list1.get(i1);
	       sb.append("<li><a href=\"javascript:void(0)\"  onclick=\"$.bringBack({id:'"+c.getId()+"', districtName:'"+c.getName()+"'})\">"+c.getName()+"("+c.getCode()+")"+"</a>");
	       if(c.getDisLevel()==1){
		  sb =   getTree(sb,c.getId());
	       }else if (c.getDisLevel()==0)
	       {
	       	
	       sb.append("</li>");
	       }
	    }
	}
	sb.append("</ul>");
	return sb;
    }

}
