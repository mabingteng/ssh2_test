package com.jialin.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jialin.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		System.out.println(request.getCharacterEncoding());
		
		if("root".equals(user.getAccountName()) && "root".equals(user.getPassword()))
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
		
		System.out.println("失败登陆用户="+user.getName());
		return "fail";
	}
	
}
