package com.jialin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQueryResultMappingBuilder.ReturnsHolder;

import com.jialin.entity.Category;
import com.jialin.entity.User;
import com.jialin.service.ICategoryService;
import com.jialin.service.IUserManage;
import com.opensymphony.xwork2.ActionContext;
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
	/**
	 * 菜单权限设置
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void pSetMenus() throws IOException{
	    HttpServletRequest req = ServletActionContext.getRequest();
	  
	    String ids = req.getParameter("ids");
	    String[] idsl = ids.split("_"); 
	    String hql1  = "update Category s set s.status= 'OFF' where s.check_Level = 1";
	    cateManage.executeHql(hql1);
	    String hql  = "update Category s set s.status= 'ON' where s.id = ";
	    for (int i=0;i<idsl.length;i++){
		if(i!=idsl.length-1)
		hql += idsl[i]+ " or s.id = ";
		else 
		    hql +=idsl[i];
	    }
	   if(idsl.length!=0){
	      cateManage.executeHql(hql);
	   }
	   Map session=ActionContext.getContext().getSession();
	   session.put("refreshFlag", "refreshFlag");
	   
	  
	}
	/**
	 * 获得各个系统的复选框，用户权限！
	 * 待扩展用户界面
	 * @return
	 */
	public String pList(){
	    HttpServletRequest req= ServletActionContext.getRequest();
	    StringBuffer sb = new StringBuffer();
	    String type = req.getParameter("type");
	    if("1".equals(type)){		
		req.setAttribute("userType", "系统管理员");
		sb.append("<fieldset><legend>系统管理<input type=\"checkbox\" name=\"g4\" class=\"checkboxCtrl\" value=\"sysManage\" group=\"c4\" /></legend>");
		sb.append("<dl class=\"nowrap\"><dd style=\"width: 800px;\">");
		sb = getCheckboxStr(type, sb);
		sb.append("</dd></dl></fieldset>");		
	    }else if("2".equals(type)){
		req.setAttribute("userType", "管理员");
		sb.append("<fieldset><legend>社会治理服务<input type=\"checkbox\" name=\"g4\" class=\"checkboxCtrl\" value=\"sysManage\" group=\"c4\" /></legend>");
		sb.append("<dl class=\"nowrap\"><dd style=\"width: 800px;\">");
		sb = getCheckboxStr(type, sb);
		sb.append("</dd></dl></fieldset>");	
		System.out.println("管理员登录菜单管理");
		
	    }
	    req.setAttribute("htmlstr", sb.toString());
	    
	    return SUCCESS;
	}
	
	
	
	private StringBuffer getCheckboxStr(String check_type,StringBuffer sb){
	    
	   String hql = "from Category where check_Level = "+check_type +"and deleteMark = 1 and disLevel = 0";
	   List<Category> list = cateManage.getByHql(hql);
	   
	   if(list!=null&&list.size()!=0){
	       for(int i=0;i<list.size();i++){
		   if(list.get(i).getStatus().equals("OFF")){
		       sb.append("<label><input type=\"checkbox\" name=\"c4\" value=\""+list.get(i).getId()+"\" />"+list.get(i).getName()+"</label>");
		   } else{
		       sb.append("<label><input type=\"checkbox\" checked=\"checked\" name=\"c4\" value=\""+list.get(i).getId()+"\" />"+list.get(i).getName()+"</label>");
		   }
	       }
	   }
	   sb.append("");
	    
	   return sb; 
	}


	
	
}
