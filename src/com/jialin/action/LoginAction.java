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
		
		if("root".equals(user.getName()) && "root123".equals(user.getPassword()))
		{
			//HttpSession se = ServletActionContext.getRequest().getSession();
			Map session=ActionContext.getContext().getSession();
			session.put("user.name", user.getName());
			
			System.out.println("成功登陆用户="+user.getName());
			return "success";
		}
		
		System.out.println("失败登陆用户="+user.getName());
		return "fail";
	}
	
}
