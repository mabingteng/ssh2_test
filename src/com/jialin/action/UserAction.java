package com.jialin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jialin.entity.Population;
import com.jialin.entity.User;
import com.jialin.service.IUserManage;
import com.jialin.service.UserManageImp;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private User user;
	private List<User> list ;

	@Resource  
	private IUserManage userManage;
	

	public User getUser() {
	    return user;
	}

	public void setUser(User user) {
	    this.user = user;
	}

	public List<User> getList() {
	    return list;
	}

	public void setList(List<User> list) {
	    this.list = list;
	}

	public void setUserManage(IUserManage userManage) {
		this.userManage = userManage;
	}
	
	public IUserManage getUserManage() {
		return userManage;
	}
	public String  uList(){
	   List<User>  ulist  = userManage.getUserList();
	     System.out.println(ulist.size());
	     System.out.println("UserManage.uList()");
		HttpServletRequest requset =  ServletActionContext.getRequest();
		
		requset.setAttribute("ulist", ulist);
		
		return "success";
	    
	    
	}
	public String uAdd() throws IOException{
	    System.out.println(this.getClass()+" :uAdd()");
	    if(user.getDes()==null){
		user.setDes("");
	    }
	    User u = userManage.getByAccountName(user.getAccountName());
	    String json ="";
	    if(u==null){
		userManage.addUser(user);
		json = " {\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"page_userlist\",\"callbackType\":\"closeCurrent\"}";
	    }else {
		json = " {\"statusCode\":\"200\", \"message\":\"该账户已存在\", \"navTabId\":\"page_userlist\",\"callbackType\":\"none\"}";
	    }
	    HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");  
		PrintWriter out =  res.getWriter();
		out.write(json);
		out.flush();
		out.close();
	    return SUCCESS;
	}
	
	public String uRefresh() throws IOException{
	   String  json = " {\"statusCode\":\"200\", \"message\":\"刷新成功\", \"navTabId\":\"page_userlist\",\"callbackType\":\"forward\"}";
	   HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");  
		PrintWriter out =  res.getWriter();
		out.write(json);
		out.flush();
		out.close(); 
	   return SUCCESS;
	}
	
	public String uDel() throws IOException{
	    userManage.deleteUser(user);
	    String  json = " {\"statusCode\":\"200\", \"message\":\"删除成功\", \"navTabId\":\"page_userlist\",\"callbackType\":\"forward\"}";
	    HttpServletResponse res = ServletActionContext.getResponse();
	    res.setCharacterEncoding("UTF-8");  
	    PrintWriter out =  res.getWriter();
	    out.write(json);
	    out.flush();
	    out.close(); 
	    return SUCCESS;
	}
	public String uUpdate() throws IOException{
	  user = userManage.getById(user.getId());
	  if(user==null) {
	      String  json = " {\"statusCode\":\"200\", \"message\":\"数据错误\", \"navTabId\":\"page_userlist\",\"callbackType\":\"forward\"}";
		    HttpServletResponse res = ServletActionContext.getResponse();
		    res.setCharacterEncoding("UTF-8");  
		    PrintWriter out =  res.getWriter();
		    out.write(json);
		    out.flush();
		    out.close(); 
	  }
	  return SUCCESS;
	}
	public String uUpdateData() throws IOException{
	    System.out.println(this.getClass()+" :uAdd()");
	    if(user.getDes()==null){
		user.setDes("");
	    }
	//    User u = userManage.getByAccountName(user.getAccountName());
	    String json ="";
	//    if(u==null){
		userManage.modifyUser(user);
		json = " {\"statusCode\":\"200\", \"message\":\"修改成功\", \"navTabId\":\"page_userlist\",\"callbackType\":\"closeCurrent\"}";
	//    }else {
	//	json = " {\"statusCode\":\"200\", \"message\":\"登录账户已存在\", \"navTabId\":\"page_userlist\",\"callbackType\":\"none\"}";
	//    }
	    HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");  
		PrintWriter out =  res.getWriter();
		out.write(json);
		out.flush();
		out.close();
	    return SUCCESS;
	}
	public String uExecute() throws UnsupportedEncodingException{
	    String hql = "from User where name like '%" +user.getName()+"%'";
	    List<User> list =  userManage.getByHql(hql);
	   
	  //  System.out.println(list.size());
	    HttpServletRequest req = ServletActionContext.getRequest();
	    req.setCharacterEncoding("utf8");
	    req.setAttribute("ulist", list);
	    return SUCCESS;
	}
}
