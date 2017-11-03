package com.example.course.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="users")
@Component
@Scope("prototype")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	@NotEmpty(message="Поле не может быть пустым")
	@Size(min=3, message="Длина поля не менее 3 символов")
	private String username;
	
	@Column(name="password")
	@NotEmpty(message="Поле не может быть пустым")
	@Size(min=6, message="Длина поля не менее 6 символов")
	private String password;

	@Column(name="email")
	@NotEmpty(message="Поле не может быть пустым")
	@Email(message="Некорректно заполнено поле")
	private String email;
	
	@Column(name="enabled")
	private int enabled;
	
	@Column(name="role")
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users", fetch = FetchType.LAZY)
	private List<Posts> posts;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users", fetch = FetchType.LAZY)
	private List<Comments> comments;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="user", fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Personaldata personaldata;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user", fetch = FetchType.LAZY)
	private List<Likespost> likespost;

	public Users() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public Personaldata getPersonaldata() {
		return personaldata;
	}

	public void setPersonaldata(Personaldata personaldata) {
		this.personaldata = personaldata;
	}

	public List<Likespost> getLikespost() {
		return likespost;
	}

	public void setLikespost(List<Likespost> likespost) {
		this.likespost = likespost;
	}
	
}
