package com.jialin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private int id;
    private int menuLevel;
    private String name ;
    private String describe;
    private int visibleLevel;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMenuLevel() {
        return menuLevel;
    }
    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public int getVisibleLevel() {
        return visibleLevel;
    }
    public void setVisibleLevel(int visibleLevel) {
        this.visibleLevel = visibleLevel;
    }
    
}
