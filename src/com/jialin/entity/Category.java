package com.jialin.entity;

import javax.persistence.Entity;

@Entity
public class Category {
    private int id;
    private int menuLevel;
    private String name ;
    private String describe;
    private int visibleLevel;
    
}
