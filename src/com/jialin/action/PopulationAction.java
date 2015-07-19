package com.jialin.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.http.HttpRequest;

import com.jialin.entity.Population;
import com.jialin.service.IPopulationManage;
import com.opensymphony.xwork2.ActionSupport;

public class PopulationAction extends ActionSupport {
	
	private Population population;
	private List<Population> list;
	
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
	
	public String pAdd(){
	    
	    return "success";
	}
	public String pAddData(){
	   
	    pManager.addPersion(population);
	    pList();
	    return "success";
	}
	public String pDel(){
		   
	    pManager.deletePersion(population);
	    pList();
	    return "success";
	}
	public String pList(){
		HttpServletRequest requset =  ServletActionContext.getRequest();
		List<Population> perlist = pManager.getPersionList();
		requset.setAttribute("perlist", perlist);
		
		return "success";
	}
	
}
