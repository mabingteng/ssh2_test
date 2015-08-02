package com.jialin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SQLQueryResultMappingBuilder.ReturnsHolder;

import com.jialin.entity.Category;
import com.jialin.entity.User;
import com.jialin.service.ICategoryService;
import com.jialin.service.IUserManage;
import com.opensymphony.xwork2.ActionSupport;


public class PriorityAction extends ActionSupport {
	
	
	@Resource  
	private ICategoryService cateManage;
	
	private String [] strList;
	
	public ICategoryService getCateManage() {
	    return cateManage;
	}

	public void setCateManage(ICategoryService cateManage) {
	    this.cateManage = cateManage;
	}

	public String execute(){
	    
	    return SUCCESS;
	    
	}
	public void pSetMenus() throws IOException{
	    HttpServletRequest req = ServletActionContext.getRequest();
	    HttpServletResponse resp = ServletActionContext.getResponse();
	    resp.setContentType("text/html");
	    resp.setCharacterEncoding("utf8");
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
	 
	    PrintWriter out =  resp.getWriter();
	    out.write("ok");
	    out.flush();
	    out.close();
	}
	
	public String pList(){
	    HttpServletRequest req= ServletActionContext.getRequest();
	    String type = req.getParameter("type");
	    if("1".equals(type)){
		
		StringBuffer sb = new StringBuffer();
		req.setAttribute("userType", "系统管理员");
		sb.append("<fieldset><legend>系统管理<input type=\"checkbox\" name=\"g4\" class=\"checkboxCtrl\" value=\"sysManage\" group=\"c4\" /></legend>");
		sb.append("<dl class=\"nowrap\"><dd style=\"width: 800px;\">");
		sb = getCheckboxStr(type, sb);
		sb.append("</dd></dl></fieldset>");
		req.setAttribute("htmlstr", sb.toString());
	    }
	   // HttpServletResponse resp = ServletActionContext.getResponse();
	    
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

	public String [] getStrList() {
	    return strList;
	}

	public void setStrList(String [] strList) {
	    this.strList = strList;
	}
	
	
}
