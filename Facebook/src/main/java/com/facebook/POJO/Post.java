package com.facebook.POJO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {
	@Transient
	private String picturePath;

	@ManyToOne
	@JoinColumn(name = "post_owner", nullable = false)
	@JsonIgnore
	private User owner;

	@OneToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "picture", referencedColumnName = "id")
	private Picture picture;

	@Column(name = "text", columnDefinition = "VARCHAR(255)")
	private String text;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JsonIgnore
	@JoinTable(name = "likes", joinColumns = { @JoinColumn(name = "post_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private Set<User> likes = new HashSet<User>();


	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JsonIgnore
	@JoinTable(name = "shares", joinColumns = { @JoinColumn(name = "post_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private Set<User> shares = new HashSet<User>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
	private List<Comment> comments = new ArrayList<Comment>();

	public Post() {}

	public Post(User owner, Picture pic, String text) {
		setOwner(owner);
		setPicture(pic);
		setText(text);
	}

	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getPicturePath() {
		return "images/" + this.owner.getEmail() + "/PostPictures/" + this.picture.getName();
	}

	public void addComment(Comment c) {
		comments.add(c);
	}

	public void removeComment(Comment c) {
		comments.remove(c);
	}
	
	public void addShare(User u){
		shares.add(u);
	}
	
	public void removeShare(User u){
		shares.remove(u);
	}
	
	public void addLike(User u) {
		synchronized(likes){
			likes.add(u);
		}
	}

	public void removeLike(User u) {
		synchronized(likes){
			likes.remove(u);
		}
	}

	public Set<User> getLikes() {
		return Collections.unmodifiableSet(likes);
	}

	public User getOwner() {
		return owner;
	}

	public Picture getPicture() {
		return picture;
	}

	public String getText() {
		return text;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<User> getShares() {
		return Collections.unmodifiableSet(shares);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Post [id=" + this.getId() + ", user=" + owner.getEmail()
				+ ", picture=" + picture + ", text=" + text + "]");
		return result.append("\nLikes: " + likes).toString();
	}

	@Override
	public boolean equals(Object o1) {
		if (Integer.valueOf(this.getId()).equals(Integer.valueOf(((Post) o1).getId()))) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(this.getId());
	}
}
