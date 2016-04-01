package com.facebook.POJO;

import java.util.Collections; 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

	@ManyToOne()
	@JoinColumn(name = "post_owner", nullable = false)
	private User owner;

	@Column(name = "picture", columnDefinition = "VARCHAR(100)")
	private String picture;

	@Column(name = "text", columnDefinition = "VARCHAR(255)")
	private String text;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class, cascade = { 
			CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "likes", joinColumns = @JoinColumn(name = "post_id", nullable = false) , 
			inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false) )
	private Set<User> likes;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> postComments;
	
	public void addComment(Comment c){
		postComments.add(c);
	}
	public void removeComment(Comment c){
		postComments.remove(c);
	}
	
	public Post() {
	}

	public Post(User owner, String pic, String text) {
		likes = new HashSet<User>();
		setOwner(owner);
		setPicture(pic);
		setText(text);
	}
	
	public void addLike(User u) {
		likes.add(u);
	}

	public void removeLike(User u) {
		likes.remove(u);
	}
	
	public Set<User> getLikes() {
		return Collections.unmodifiableSet(likes);
	}

	public User getOwner() {
		return owner;
	}

	public String getPicture() {
		return picture;
	}

	public String getText() {
		return text;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Post [id=" + this.getId() + ", user=" + owner.getEmail()
				+ ", picture=" + picture + ", text=" + text + "]");
		return result.append("\nLikes: " + likes).toString();
	}
}
