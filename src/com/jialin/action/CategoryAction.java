package com.jialin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jialin.entity.Category;
import com.jialin.entity.User;
import com.jialin.service.ICategoryService;
import com.jialin.service.IUserManage;
import com.opensymphony.xwork2.ActionSupport;


public class CategoryAction extends ActionSupport {
	
	private Category cate;
	private List<Category> list ;

	@Resource  
	private ICategoryService cateManage;
	
	
	
	public ICategoryService getCateManage() {
	    return cateManage;
	}

	public void setCateManage(ICategoryService cateManage) {
	    this.cateManage = cateManage;
	}

	public Category getCate() {
	    return cate;
	}

	public void setCate(Category cate) {
	    this.cate = cate;
	}

	public List<Category> getList() {
	    return list;
	}

	public void setList(List<Category> list) {
	    this.list = list;
	}

	
	public String  cList(){
	   List<Category>  ulist  = cateManage.getCategoryList();
	     System.out.println("category ---  clist");
	   
		HttpServletRequest requset =  ServletActionContext.getRequest();
		
		requset.setAttribute("clist", ulist);
		
		return "success";
	    
	    
	}
	public String cAdd() throws IOException{
        	HttpServletRequest req = ServletActionContext.getRequest();
        	req.setCharacterEncoding("utf8");
        	long ParentId = Long.parseLong(req.getParameter("orgLookup.id"));
        	String json = "";
        	cate.setParentID(ParentId);
        	cate.setDisLevel(0);
        	cate.setDeleteMark("1");
        	cateManage.add(cate);
        	//Category c = cateManage.getById(ParentId);
        	//c.setDisLevel(1);
        	
        	//cateManage.update(c);
 
        	json = " {\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"page_catelist\",\"callbackType\":\"closeCurrent\"}";
        	HttpServletResponse res = ServletActionContext.getResponse();
        	res.setCharacterEncoding("UTF-8");
        	PrintWriter out = res.getWriter();
        	out.write(json);
        	out.flush();
        	out.close();
        	return SUCCESS;
	}
	
	public String cRefresh() throws IOException{
	  String  json = " {\"statusCode\":\"200\", \"message\":\"刷新成功\", \"navTabId\":\"page_catelist\",\"callbackType\":\"forward\"}";
	   HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");  
		PrintWriter out =  res.getWriter();
		out.write(json);
		out.flush();
		out.close();
	   return SUCCESS;
	}
	
	public String cDel() throws IOException{
	   System.out.println("==========cDel()========");
	    cateManage.del(cate);
	    String  json = " {\"statusCode\":\"200\", \"message\":\"删除成功\", \"navTabId\":\"page_catelist\",\"callbackType\":\"forward\"}";
	    HttpServletResponse res = ServletActionContext.getResponse();
	    res.setCharacterEncoding("UTF-8");  
	    PrintWriter out =  res.getWriter();
	    out.write(json);
	    out.flush();
	    out.close(); 
	    return SUCCESS;
	}
	public String uUpdate() throws IOException{
	 /* cate = cateManage.getById(cate.getId());
	  if(cate==null) {
	      String  json = " {\"statusCode\":\"200\", \"message\":\"数据错误\", \"navTabId\":\"page_userlist\",\"callbackType\":\"forward\"}";
		    HttpServletResponse res = ServletActionContext.getResponse();
		    res.setCharacterEncoding("UTF-8");  
		    PrintWriter out =  res.getWriter();
		    out.write(json);
		    out.flush();
		    out.close(); 
	  }*/
	  return SUCCESS;
	}
	public String uUpdateData() throws IOException{
	    return SUCCESS;
	}
	public String uExecute() throws UnsupportedEncodingException{
	 /*   String hql = "from User where name like '%" +user.getName()+"%'";
	    List<User> list =  cateManage.getByHql(hql);
	   
	  //  System.out.println(list.size());
	    HttpServletRequest req = ServletActionContext.getRequest();
	    req.setCharacterEncoding("utf8");
	    req.setAttribute("ulist", list);*/
	    return SUCCESS;
	}
	public String cSelectList() throws UnsupportedEncodingException{
	    String selectList = "";
	    selectList = cateManage.getMenuList();
	    HttpServletRequest req = ServletActionContext.getRequest();
	    req.setCharacterEncoding("utf8");
	    req.setAttribute("selectList", selectList);
          
   
	    return SUCCESS;
	}
}
