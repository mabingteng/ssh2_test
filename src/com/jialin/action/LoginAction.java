package com.jialin.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jialin.entity.User;
import com.jialin.service.ICategoryService;
import com.jialin.service.IUserManage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("unchecked")
public class LoginAction extends ActionSupport {
	private User user;
	
	@Resource  
	private IUserManage userManage;
	
	public void setUserManage(IUserManage userManage) {
		this.userManage = userManage;
	}
	
	public IUserManage getUserManage() {
		return userManage;
	}
	
	@Resource  
	private ICategoryService cateManage;
	
	
	
	public ICategoryService getCateManage() {
	    return cateManage;
	}

	public void setCateManage(ICategoryService cateManage) {
	    this.cateManage = cateManage;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public String execute() throws Exception {
		
	    
	    Map session=ActionContext.getContext().getSession();
	  
	    String refreshFlag  = (String) session.get("refreshFlag");
	    if(refreshFlag==null){
	    return  Login();
	    }else{
		session.remove("refreshFlag");
		String menuList = cateManage.getTreeMenuList("系统管理员");
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setCharacterEncoding("utf8");
		req.setAttribute("menuList", menuList);
		req.setAttribute("Folder", "系统管理");
		req.setAttribute("toggleCollapse", "系统管理服务");
		return "admin";
	    }
	    
		
		
	}
	private String Login(  ) throws UnsupportedEncodingException{
	    Map session=ActionContext.getContext().getSession();
	    String  userType = userManage.findUserByAccountnameAndPassword(user.getAccountName(), user.getPassword());
	    session.put("accountName", user.getAccountName());
	    session.put("userType",userType);
	    String menuList = cateManage.getTreeMenuList(userType);
	    HttpServletRequest req = ServletActionContext.getRequest();
	    req.setCharacterEncoding("utf8");
	    req.setAttribute("menuList", menuList);
	   if(userType==null){
		    return "fail";
		} else if ("系统管理员".equals(userType)){   
		    
		    req.setAttribute("Folder", "系统管理");
		    req.setAttribute("toggleCollapse", "系统管理服务");		    
		    return "admin";
		}else if ("管理员".equals(userType)){
		    req.setAttribute("Folder", "社会治理");
		    req.setAttribute("toggleCollapse", "社会治理服务");
		 //   return "admin";   //功能已实现
		   return SUCCESS;
		}else if ("用户".equals(userType)){
		    req.setAttribute("Folder", "系统管理");
		    req.setAttribute("toggleCollapse", "系统管理服务");
		    return "user";
		}
	    return SUCCESS;
	}
	
}
