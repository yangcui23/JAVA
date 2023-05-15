package com.yang.projectmanager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="First name is required!")
    private String firstName;
	@NotEmpty(message="Last name is required!")
	private String lastName;
	
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
	
	@NotEmpty(message="Password is required!")
    @Size(min=8, message="Password must be at least 8 characters")
    private String password;
	
	@Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, message="Confirm Password must be at least 8 characters")
    private String confirm;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
   	@JoinTable(
   			name = "users_projects",
   			joinColumns = @JoinColumn(name = "user_id"),
   			inverseJoinColumns = @JoinColumn(name = "project_id")
   	)
       private List<Project> projects;
       
       @Column(updatable=false)
       @OneToMany(mappedBy="lead", fetch = FetchType.LAZY)
       private List<Project> projectsLead;
     
       public User() {}
    
       @OneToMany(mappedBy = "members", fetch = FetchType.LAZY)
       private List<Task> tasks;
    
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
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



	public String getConfirm() {
		return confirm;
	}



	public void setConfirm(String confirm) {
		this.confirm = confirm;
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



	public List<Project> getProjects() {
		return projects;
	}



	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}



	public List<Project> getProjectsLed() {
		return projectsLead;
	}



	public void setProjectsLed(List<Project> projectsLed) {
		this.projectsLead = projectsLed;
	}
	


	public List<Project> getProjectsLead() {
		return projectsLead;
	}



	public void setProjectsLead(List<Project> projectsLead) {
		this.projectsLead = projectsLead;
	}



	public List<Task> getTasks() {
		return tasks;
	}



	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}



	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
