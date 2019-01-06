package com.vidisha.beltexam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="ideas")
public class Idea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(min=2, message="Cannot leave the Content Empty")
	private String content;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User host;
    
    
    
    public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}



	@ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(
    		name = "users_ideas",
    		joinColumns = @JoinColumn(name = "idea_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    		)
    private List<User> users;
    public Idea() {
    	
    }

	

	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	
	@PrePersist 
	protected void onCreate(){ 
	this.createdAt = new Date(); 
	} 
	@PreUpdate 
	protected void onUpdate(){ 
	this.updatedAt = new Date(); 
	} 
	
}
