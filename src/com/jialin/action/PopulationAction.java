package com.jialin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jialin.entity.Population;
import com.jialin.service.IPopulationManage;
import com.opensymphony.xwork2.ActionSupport;

public class PopulationAction extends ActionSupport {
	
	private Population population;
	private List<Population> list;
	private int id;
	private int currentpage;/*当前第几页*/
	private int totalPage;/*一共多少页*/
	private int recordNumber;/*当前查询的总记录数目*/
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}


	@Resource
	private IPopulationManage pManager;
	
	public Population getPopulation() {
		return population;	
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	public List<Population> getList() {
		list = pManager.getPersionList();
		return list;
	}

	public void setList(List<Population> list) {
		this.list = list;
	}

	public IPopulationManage getpManager() {
		return pManager;
	}

	public void setpManager(IPopulationManage pManager) {
		this.pManager = pManager;
	}

	
	public String pList(){
		HttpServletRequest request =  ServletActionContext.getRequest();
		List<Population> perlist = pManager.getPersionList();
		request.setAttribute("perlist", perlist);
		
		return "success";
	}
	public String PAdd(){
		
		
		return "success";
	}
    public String pUpdate() throws IOException{

	 population=pManager.findPersionById(population.getId());
	
		return "success";
	}
   
    public String Update() throws IOException
    {
	    pManager.modifyPersion(population);
		String json = " {\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"page1\",\"callbackType\":\"closeCurrent\"}";
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");  
		PrintWriter out =  res.getWriter();
		out.write(json);
		out.flush();
		out.close();
	  
	   return "success";
    }
   
	public String addPerson() throws IOException {
	    
		pManager.addPersion(population);
		
		String json = " {\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"page1\",\"callbackType\":\"closeCurrent\"}";
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");  
		PrintWriter out =  res.getWriter();
		out.write(json);
		out.flush();
		out.close();
		//String sql="select * from p_population ";
		//boolean flag = true;
		
		return "success";
	}
	public String pDel() throws IOException{
		
		pManager.deletePersion(population);
		String json = " {\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"page1\",\"callbackType\":\"none\"}";
		HttpServletResponse res = ServletActionContext.getResponse();
		res.setCharacterEncoding("UTF-8");  
		PrintWriter out =  res.getWriter();
		out.write(json);
		out.flush();
		out.close();
		return "success";
	}
	
    public String pRefresh() throws IOException{
	HttpServletRequest requset =  ServletActionContext.getRequest();
	List<Population> perlist = pManager.getPersionList();
	requset.setAttribute("perlist", perlist);
	
	String json = "{\"tusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"navNewsLi\", \"forwardUrl\":\"\", \"callbackType\":\"closeCurrent\"}";
	HttpServletResponse res = ServletActionContext.getResponse();
	res.setCharacterEncoding("UTF-8");  
	PrintWriter out =  res.getWriter();
	out.write(json);
	out.flush();
	out.close();		
	return "success";
	}
    
    public String execute() throws Exception 
   {
		
	   HttpServletRequest request=ServletActionContext.getRequest();
		
		//System.out.println(request.getCharacterEncoding());
	    String hql=null; 
		String name=population.getName();
		String Room_num=population.getRoom_num();
		int  Id_num=population.getId_num();
	    //String ID_NUM=String.valueOf(Id_num);
		boolean flag=true;
	
		
	if(Room_num.hashCode()!=0||name.hashCode()!=0||Id_num!=0)
	{		
		if(name.hashCode()!=0)
		{
			if(flag)
			{			
				hql="from Population a where a.name like "+"'%"+name+"%'";   
				
			}
			else
			{
				hql+="and  a.name like "+name;
				
			}
			
			flag=false;
		}
		
		if(Room_num.hashCode()!=0)
		{
			if(flag)
			{
				hql="from Population a where a.room_num like "+"'%"+Room_num+"%'";
			}
			
			else
			{
				hql+="and a.room_num like" +"'%"+Room_num+"%'";
			}
			flag=false;
		}
		if(Id_num!=0)
		{
			if(flag)
			{
				hql="from Population a where a.id_num like "+"'%"+Id_num+"%'";
			}
			
			else
			{
				hql+="and a.id_num like"+"'%"+Id_num+"%'";
			}
		}
		
		List<Population> perlist = pManager.getALLPersonLsit(hql);
		request.setAttribute("perlist", perlist);
		//return "success";	
	}
	
	else
		{
		
		List<Population> perlist = pManager.getPersionList();
		request.setAttribute("perlist", perlist);
		}
		
		return "success";			
			
			
	}
}
