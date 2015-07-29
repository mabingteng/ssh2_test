package com.jialin.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jialin.dao.AdminDaoImp;
import com.jialin.entity.Admin;
import com.jialin.service.IAdminManage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginCheckAction  extends ActionSupport {
  
	/**
	 * 
	 */
	
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String Check()
	{
		return "success";
	}
	private  IAdminManage aManage;
	
	public IAdminManage getaManage() {
		return aManage;
	}

	public void setaManage(IAdminManage aManage) {
		this.aManage = aManage;
	} 
	
	
	public String CheckLogin()
	
	{ 
		 HttpServletRequest request=ServletActionContext.getRequest();
		 
		 String name=admin.getACCOUNTNAME();
		 String pd=admin.getACCOUNTPASSWORD();
		// AdminDaoImp adminDao=new AdminDaoImp();
		 ActionContext ctx=ActionContext.getContext();
		 //@SuppressWarnings("unused")
		// boolean  be=aManage.CheckLogin(admin);
		 if(aManage.CheckLogin(admin))
		 {  
			 ctx.put("error", java.net.URLEncoder.encode(aManage.getErrMessage()));
			 return "false";
		 }
		     ctx.getSession().put("ACCOUNTNAME", admin.getACCOUNTNAME());
		     return "success";
	}

	
}
