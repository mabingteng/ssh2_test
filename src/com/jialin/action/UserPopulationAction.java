package com.jialin.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.jialin.entity.Population;
import com.jialin.service.IUserPopulationManage;
import com.opensymphony.xwork2.ActionSupport;

public class UserPopulationAction extends ActionSupport {
	
	private Population population;
	private List<Population> list;
	
	@Resource
	private IUserPopulationManage userpManager;
	
	public Population getPopulation() {
		return population;	
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	public List<Population> getList() {
		list = userpManager.getPersionList();
		return list;
	}

	public void setList(List<Population> list) {
		this.list = list;
	}

	public IUserPopulationManage getpManager() {
		return userpManager;
	}

	public void setpManager(IUserPopulationManage pManager) {
		this.userpManager = pManager;
	}
	
	public String pAdd(){
	    
	    return "success";
	}
	public String pAddData(){
	   
	    userpManager.addPersion(population);
	    pList();
	    return "success";
	}
	public String pDel(){
		   
	    userpManager.deletePersion(population);
	    pList();
	    return "success";
	}
	public String pList(){
	    	System.out.println("Population.pList()");
		HttpServletRequest requset =  ServletActionContext.getRequest();
		List<Population> perlist = userpManager.getPersionList();
		requset.setAttribute("perlist", perlist);
		
		return "success";
	}
	
}
