package com.facebook.POJO;

import java.util.ArrayList;
import java.util.Collections; 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {
	@Transient
	private String picturePath;
	
	@ManyToOne
	@JoinColumn(name = "post_owner", nullable = false)
	private User owner;

	@OneToOne(orphanRemoval=true)
	@JoinColumn(name = "picture", referencedColumnName = "id")
	private Picture picture;

	@Column(name = "text", columnDefinition = "VARCHAR(255)")
	private String text;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = User.class, cascade = { 
			CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "likes", joinColumns = @JoinColumn(name = "post_id", nullable = false) , 
			inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false) )
	private Set<User> likes;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
	private List<Comment> comments = new ArrayList<Comment>();
	
	public Post() {}

	public Post(User owner, Picture pic, String text) {
		likes = new HashSet<User>();
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
	
	public void addComment(Comment c){
		comments.add(c);
	}
	
	public void removeComment(Comment c){
		comments.remove(c);
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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Post [id=" + this.getId() + ", user=" + owner.getEmail()
				+ ", picture=" + picture + ", text=" + text + "]");
		return result.append("\nLikes: " + likes).toString();
	}
	
	 @Override
	    public boolean equals(Object o1) {


	        if( Integer.valueOf(this.getId()).equals( Integer.valueOf(((Post)o1).getId()))){
	                return true;
	        }
	        return false;
	    }


	    @Override
	    public int hashCode() {

	        
	        return Integer.valueOf(this.getId());
	    }
}
