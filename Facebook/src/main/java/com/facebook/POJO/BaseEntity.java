package com.facebook.POJO;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created = new Date();
  
    public int getId() {
        return id;
    }
    
    private void setId(int id) {
        this.id = id;
    }
      
    public Date getCreated() {
		return created;
	}
}