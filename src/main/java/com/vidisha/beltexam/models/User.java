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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2, message="Please provide First Name!")
	private String firstname;
	@Size(min=3, message="Please provide Last Name!")
	private String lastname;
	@Email(message="Email must be valid")
    private String email;
	@Size(min=2, message="Cannot Leave the field empty")
	private String location;
	@Size(min=2, message="Enter the state")
	private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private List<Like> likes;
    
    public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
//	
//	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
//	private List<Idea> ideas;
    
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(
    		name = "users_ideas",
    		joinColumns = @JoinColumn(name = "user_id"),
    		inverseJoinColumns = @JoinColumn(name = "idea_id")
    		)
    private List<Idea> listideas;
    
    public User() {
    	
    }

	public List<Idea> getListideas() {
		return listideas;
	}

	public void setListideas(List<Idea> listideas) {
		this.listideas = listideas;
	}

//	public List<Idea> getIdeas() {
//		return ideas;
//	}
//
//	public void setIdeas(List<Idea> ideas) {
//		this.ideas = ideas;
//	}

	
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	

//	public List<Idea> getIdeas() {
//		return ideas;
//	}
//
//	public void setIdeas(List<Idea> ideas) {
//		this.ideas = ideas;
//	}

	@PrePersist 
	protected void onCreate(){ 
	this.createdAt = new Date(); 
	} 
	@PreUpdate 
	protected void onUpdate(){ 
	this.updatedAt = new Date(); 
	} 
}
