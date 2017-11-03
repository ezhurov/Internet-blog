package com.example.course.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="posts")
@Component
@Scope("prototype")
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="theme")
	@NotEmpty(message="Поле не может быть пустым")
	@Size(min=3, message="Минимальная длина поля 3 символа")
	private String theme;
	
	@Column(name="post")
	@NotEmpty(message="Поле не может быть пустым")
	@Size(min=3, message="Минимальная длина поля 3 символа")
	private String post;
	
	@Column(name="datatime")
	private String datatime;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private Users users;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="posts", fetch = FetchType.LAZY)
	private List<Comments> comments;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="post", fetch = FetchType.LAZY)
	private List<Images> images;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="post", fetch = FetchType.LAZY)
	private List<Likespost> likespost;
	
	public Posts() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDatatime() {
		return datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public List<Likespost> getLikespost() {
		return likespost;
	}

	public void setLikespost(List<Likespost> likespost) {
		this.likespost = likespost;
	}
	
}
