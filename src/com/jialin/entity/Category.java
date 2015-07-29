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
    
}
