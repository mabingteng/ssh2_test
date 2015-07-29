package com.jialin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p_admin")
public class Admin {


    private int ID;//主键
	private String ACCOUNTNAME;
	private String ACCOUNTPASSWORD;
	private String  NAME;
	private String SEX;
	private String PHONE;
	private String PHONE1;
	private String EMAIL;
	private String QUESTION;
	private String ANSWERQUESTION;
	private String REMARK;
	private String UserType;//使用者类型
	private String ID_NUM;//身份证号码
	
	@Id
	@GeneratedValue
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Column(name="ACCOUNTNAME", length=60, nullable=false, unique=true)
	public String getACCOUNTNAME() {
		return ACCOUNTNAME;
	}
	public void setACCOUNTNAME(String aCCOUNTNAME) {
		ACCOUNTNAME = aCCOUNTNAME;
	}
	@Column(name="ACCOUNTPASSWORD", length=60, nullable=false, unique=true)
	public String getACCOUNTPASSWORD() {
		return ACCOUNTPASSWORD;
	}
	public void setACCOUNTPASSWORD(String aCCOUNTPASSWORD) {
		ACCOUNTPASSWORD = aCCOUNTPASSWORD;
	}
	@Column(name="NAME", length=60, nullable=false, unique=true)
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String sEX) {
		SEX = sEX;
	}
	@Column(name="PHONE", length=90, nullable=false, unique=true)
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getPHONE1() {
		return PHONE1;
	}
	public void setPHONE1(String pHONE1) {
		PHONE1 = pHONE1;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getQUESTION() {
		return QUESTION;
	}
	public void setQUESTION(String qUESTION) {
		QUESTION = qUESTION;
	}
	public String getANSWERQUESTION() {
		return ANSWERQUESTION;
	}
	public void setANSWERQUESTION(String aNSWERQUESTION) {
		ANSWERQUESTION = aNSWERQUESTION;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	@Column(name="ID_NUM", length=225, nullable=false, unique=true)
	public String getID_NUM() {
		return ID_NUM;
	}
	public void setID_NUM(String iD_NUM) {
		ID_NUM = iD_NUM;
	}
	
	
	
}
