package com.jialin.action;

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

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		System.out.println(request.getCharacterEncoding());
		String type = userManage.findUserByAccountnameAndPassword(user.getAccountName(), user.getPassword());
		if(type==null){
		    return "fail";
		} else if ("系统管理员".equals(type)){
		    Map session=ActionContext.getContext().getSession();
		    session.put("accountName", user.getAccountName());
		    String menuList = cateManage.getTreeMenuList(type);
		    HttpServletRequest req = ServletActionContext.getRequest();
		    req.setCharacterEncoding("utf8");
		    req.setAttribute("menuList", menuList);
		    req.setAttribute("Folder", "系统管理");
		    req.setAttribute("toggleCollapse", "系统管理服务");
		    
		    return "admin";
		}else if ("管理员".equals(type)){
		    
		    return SUCCESS;
		}else if ("用户".equals(type)){
		    
		    return "user";
		}
		
		/*if("root".equals(user.getAccountName()) && "root".equals(user.getPassword()))
		{
			//HttpSession se = ServletActionContext.getRequest().getSession();
			Map session=ActionContext.getContext().getSession();
			session.put("accountName", user.getAccountName());
			
			System.out.println("成功登陆用户="+user.getName());
			return "success";
		}
		if("admin".equals(user.getAccountName()) && "admin".equals(user.getPassword()))
		{
			//HttpSession se = ServletActionContext.getRequest().getSession();
			Map session=ActionContext.getContext().getSession();
			session.put("accountName", user.getAccountName());
			
			System.out.println("成功登陆用户="+user.getName());
			return "admin";
		}
		*/
		System.out.println("失败登陆用户="+user.getName());
		return "fail";
	}
	
}
