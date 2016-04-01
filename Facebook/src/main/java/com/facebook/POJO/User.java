package com.facebook.POJO;

import java.io.File; 
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class User extends BaseEntity {
	public static final String STORAGE_PATH = "C:" + File.separator + "images" + File.separator + "users" + File.separator;

	@Column(name = "first_name", columnDefinition = "VARCHAR(32)")

	private String firstName;

	@Column(name = "last_name", columnDefinition = "VARCHAR(32)")
	private String lastName;

	@Column(name = "email", columnDefinition = "VARCHAR(64)", unique = true)
	private String email;

	@Column(name = "password", columnDefinition = "VARCHAR(255)")
	private String password;

	@OneToOne
	@JoinColumn(name="profile_pic", referencedColumnName="id")
	private Picture profilePicture;

	@ManyToMany
	@JoinTable(name = "friendships", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
	private Set<User> friends;

	@ManyToMany(mappedBy = "friends")
	private Set<User> befriendedBy = new HashSet<User>();

	@ManyToMany(mappedBy = "likes")
	private Set<Post> likedPosts;

	@OneToMany(mappedBy = "owner", cascade = { CascadeType.REFRESH })
	private List<Comment> userComments;

	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private UserInfo userInfo;

	public User() {}

	public User(User u){
		this(u.getEmail(),u.getPassword(), u.getFirstName(), u.getLastName());
	}
	
	public User(String email, String password, String firstName, String lastName) {
		friends = new HashSet<User>();
		likedPosts = new HashSet<Post>();
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setEmail(email);
	}
	
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public Set<Post> getLikedPosts() {
		return Collections.unmodifiableSet(likedPosts);
	}

	public void addFriend(User friend) {
		friends.add(friend);
	}

	public void removeFriend(User friend) {
		friends.remove(friend);
	}

	public void addComment(Comment c) {
		userComments.add(c);
	}

	public void removeComment(Comment c) {
		userComments.remove(c);
	}

	public void setFirstName(String firstName) {
		if (firstName != null && !firstName.isEmpty()) {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (lastName != null && !lastName.isEmpty()) {
			this.lastName = lastName;
		}
	}

	public void setPassword(String password) {
		if (password != null && !password.isEmpty()) {
			this.password = password;
		}
	}

	public void setEmail(String email) {
		if (email != null && !email.isEmpty()) {
			this.email = email;
		}
	}

	public void setProfilePicture(Picture pic) {
		if (pic != null) {
			this.profilePicture = pic;
		}
	}

	public Set<User> getFriends() {
		return this.friends;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public Picture getProfilePicture() {
		return this.profilePicture;
	}

	@Override
	public String toString() {
		return "User [userId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", profilePicture=" + profilePicture + "]";
	}
	
	public void copy(User u){
		setFirstName(u.getFirstName());
		setLastName(u.getLastName());
	}
}
