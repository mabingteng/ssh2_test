package com.jialin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
    
    private long id;   
    private  String Code;// [varchar](20) NOT NULL,
    private  String Name;//	[NAME] [varchar](50) NOT NULL,
    private  long ParentID;//	[PARENTID] [int] NOT NULL,
    private  String ActionUrl;//	[LINKURL] [varchar](255) NULL,
    private  String DeleteMark;//	[DELETEMARK] [int] NOT NULL,
    private  int Sort;// 		[SORT] [int] NOT NULL,   
    private  int Check_Level;//	[Check_Level] [int] NOT NULL,
    //菜单树深度
    private  int DisLevel;
    
    //分组或者菜单
    private  int ModelType;//	[MODULETYPE] [int] NOT NULL,   
    private  String Des;//	[DESCRIPTION] [varchar](255) NULL,
    private  int Belong_System;//	[Belong_System] [int] NOT NULL,
    private  String ICO;//	[ICO] [varchar](255) NULL,
    private  String Status;//	[STATUS] [varchar](5) NULL,
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(length=20,nullable=false)
    public String getCode() {
        return Code;
    }
    public void setCode(String code) {
        Code = code;
    }
    @Column(length=50,nullable=false)
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    @Column(nullable=false)
    public long getParentID() {
        return ParentID;
    }
    public void setParentID(long parentID) {
        ParentID = parentID;
    }
    public String getICO() {
        return ICO;
    }
    public void setICO(String iCO) {
        ICO = iCO;
    }
    @Column(length=255,nullable=false)
    public String getActionUrl() {
        return ActionUrl;
    }
    public void setActionUrl(String actionUrl) {
        ActionUrl = actionUrl;
    }
    @Column(length=255)
    public String getDes() {
        return Des;
    }
    public void setDes(String des) {
        Des = des;
    }
    @Column(nullable=false)
    public String getDeleteMark() {
        return DeleteMark;
    }
    public void setDeleteMark(String deleteMark) {
        DeleteMark = deleteMark;
    }
    public int getSort() {
        return Sort;
    }
    @Column(length=20,nullable=false)
    public void setSort(int sort) {
        Sort = sort;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
   
    public int getModelType() {
        return ModelType;
    }
    public void setModelType(int modelType) {
        ModelType = modelType;
    }
    public int getBelong_System() {
        return Belong_System;
    }
    public void setBelong_System(int belong_System) {
        Belong_System = belong_System;
    }
    @Column(nullable=false)
    public int getCheck_Level() {
        return Check_Level;
    }
    public void setCheck_Level(int check_Level) {
        Check_Level = check_Level;
    }
    @Column(nullable=false) 
    public int getDisLevel() {
        return DisLevel;
    }
    public void setDisLevel(int disLevel) {
        DisLevel = disLevel;
    }
   
}
