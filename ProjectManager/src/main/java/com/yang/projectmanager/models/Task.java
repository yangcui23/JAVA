package com.yang.projectmanager.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class Task {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    @NotEmpty(message = "Please enter a task.")
	    @Size(min = 3, max = 255, message = "Task must be at least 3 characters.")
	    private String activity;


	    @Column(updatable = false)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date updatedAt;

	    
	    // M:1 - many tasks can be done by one member
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "member_id")
	    private User members;

	    // M:1 - many tasks belong to one project
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "project_id")
	    private Project project;

	    
	    public Task() {
	    }


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getActivity() {
			return activity;
		}


		public void setActivity(String activity) {
			this.activity = activity;
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


		public User getMembers() {
			return members;
		}


		public void setMembers(User members) {
			this.members = members;
		}


		public Project getProject() {
			return project;
		}


		public void setProject(Project project) {
			this.project = project;
		}
	    
	    
	    
	    
}
