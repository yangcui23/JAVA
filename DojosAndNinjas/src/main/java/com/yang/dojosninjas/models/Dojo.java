package com.yang.dojosninjas.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Entity
@Table(name="dojos")
public class Dojo {
	
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotNull
	    @Size(min = 1, max = 255 , message="Name must be at least 1 characters.")
	    private String location;
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    @OneToMany(mappedBy="dojos",  fetch=FetchType.LAZY)
	    private List<Ninja> ninja;
	    
	    
	    
	    public Dojo() {
	    	
	    }
	    public Dojo(String location) {
	    	this.location = location;
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public List<Ninja> getNinja() {
			return ninja;
		}
		public void setNinja(List<Ninja> ninja) {
			this.ninja = ninja;
		}
		
		@PrePersist 
	    protected void onCreate() {
	        this.createdAt = new Date();
	    }

	    @PreUpdate 
	    protected void onUpdate() {
	        this.updatedAt = new Date();
	    }
		
	    
	    
	
}
