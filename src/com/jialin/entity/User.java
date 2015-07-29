package com.jialin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p_user")
public class User {
    	@Id
    	@GeneratedValue
	private int id;
    	@Column(length=20,nullable=false,unique=true)
    	private String name;
    	@Column(length=20,nullable=false,unique=true)
    	private String accountName;
    	@Column(length=20,nullable=false)
    	private String sex;
    	@Column(length=20,nullable=false)
    	private int tel;
    	@Column(length=40)
    	private  String email;
    	@Column(length=20,nullable=false)
    	private String password;
    	private String  status;
    	private  String deleteMark;
    	private  String organized;
	public int getId() {
	    return id;
	}
	public void setId(int id) {
	    this.id = id;
	}
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	public String getAccountName() {
	    return accountName;
	}
	public void setAccountName(String accountName) {
	    this.accountName = accountName;
	}
	public String getSex() {
	    return sex;
	}
	public void setSex(String sex) {
	    this.sex = sex;
	}
	public int getTel() {
	    return tel;
	}
	public void setTel(int tel) {
	    this.tel = tel;
	}
	public String getEmail() {
	    return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}
	public String getPassword() {
	    return password;
	}
	public void setPassword(String password) {
	    this.password = password;
	}
	public String getStatus() {
	    return status;
	}
	public void setStatus(String status) {
	    this.status = status;
	}
	public String getDeleteMark() {
	    return deleteMark;
	}
	public void setDeleteMark(String deleteMark) {
	    this.deleteMark = deleteMark;
	}
	public String getOrganized() {
	    return organized;
	}
	public void setOrganized(String organized) {
	    this.organized = organized;
	}
	
		
	
}
