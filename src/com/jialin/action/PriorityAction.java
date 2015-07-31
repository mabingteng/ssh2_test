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


public class PriorityAction extends ActionSupport {
	
	
	@Resource  
	private ICategoryService cateManage;
	
	
	
	public ICategoryService getCateManage() {
	    return cateManage;
	}

	public void setCateManage(ICategoryService cateManage) {
	    this.cateManage = cateManage;
	}

	public String execute(){
	    return SUCCESS;
	    
	}
	public String pList(){
	    return SUCCESS;
	}
	
}
