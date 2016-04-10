package com.facebook.POJO;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="comments")
public class Comment extends BaseEntity{

	@Column(name="text", columnDefinition="VARCHAR(255)")
	private String text;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="post", nullable=false)
	private Post post;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="owner", nullable=false)
	private User owner;
	
	public Comment() {}

	public Comment(User owner, Post post, String text){
		setOwner(owner);
		setPost(post);
		setText(text);
	}

	public String getText() {
		return text;
	}

	public Post getPost() {
		return post;
	}

	public User getOwner() {
		return owner;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}

