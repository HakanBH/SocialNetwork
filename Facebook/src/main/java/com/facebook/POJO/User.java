package com.facebook.POJO;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.facebook.DAO.SessionDispatcher;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "email" }))
public class User extends BaseEntity {
	public static final String STORAGE_PATH = "C:" + File.separator + "images" + File.separator + "users"
			+ File.separator;
	public static final int NUMBER_OF_FRIEND_SUGGESTIONS = 4;

	@Transient
	@JsonIgnore
	private String profilePath;
	@Transient
	@JsonIgnore
	private String bgPath;

	@Column(name = "first_name", columnDefinition = "VARCHAR(32)", nullable = false)
	private String firstName;

	@Column(name = "last_name", columnDefinition = "VARCHAR(32)", nullable = false)
	private String lastName;

	@Column(name = "email", columnDefinition = "VARCHAR(64)", unique = true, nullable = false)
	private String email;

	@Column(name = "password", columnDefinition = "VARCHAR(255)", nullable = false)
	private String password;

	@OneToOne
	@JoinColumn(name = "profile_pic")
	private Picture profilePicture;
	// Background
	@OneToOne
	@JoinColumn(name = "bg_pic")
	private Picture bgPicture;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
	private Set<Album> albums = new HashSet<Album>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
	private List<Post> ownedPosts = new ArrayList<Post>();

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "likes")
	private Set<Post> likedPosts = new HashSet<Post>();

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "shares")
	private Set<Post> sharedPosts = new HashSet<Post>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "friendships", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "friend_id"))
	private Set<User> friends = new TreeSet<User>((o1,o2)->{
		return o1.getFirstName().compareTo(o2.getFirstName());
	});

	@ManyToMany(mappedBy = "friends")
	private Set<User> befriendedBy = new HashSet<User>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
	private List<Comment> userComments;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserInfo userInfo;

	public User() {
	}

	public User(User u) {
		this(u.getEmail(), u.getPassword(), u.getFirstName(), u.getLastName());
	}

	public User(String email, String password, String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setEmail(email);
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

	public void addPost(Post p) {
		ownedPosts.add(p);
	}

	public void removePost(Post p) {
		ownedPosts.remove(p);
	}

	public void addAlbum(Album a) {
		albums.add(a);
	}

	public void removeAlbum(Album a) {
		albums.remove(a);
	}

	public void likePost(Post p) {
		likedPosts.add(p);
	}

	public void unlikePost(Post p) {
		likedPosts.remove(p);
	}

	public void sharePost(Post p) {
		sharedPosts.add(p);
	}

	@Override
	public String toString() {
		return "User [userId=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", profilePicture=" + profilePicture + "]";
	}

	public void copy(User u) {
		setFirstName(u.getFirstName());
		setLastName(u.getLastName());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User temp = (User) (obj);
			return this.getEmail().equals(temp.getEmail());
		}
		return false;
	}

	public List<User> getFriendsOfFriends() {
		List<User> all = new ArrayList<User>();
		for (User friend : friends) {
			for (User friendOfFriend : friend.getFriends()) {
				if (!friends.contains(friendOfFriend) && !all.contains(friendOfFriend)) {
					all.add(friendOfFriend);
				}
			}
		}

		Collections.shuffle(all);
		if (all.size() < NUMBER_OF_FRIEND_SUGGESTIONS) {
			return all;
		}
		return all.subList(0, NUMBER_OF_FRIEND_SUGGESTIONS);
	}

	public Collection<Post> getPosts() {
		Set<Post> result = new TreeSet<Post>((o1, o2) -> {
			return o2.getCreated().compareTo(o1.getCreated());
		});

		for (User u : friends) {
			result.addAll(u.getOwnedPosts());
		}

		result.addAll(ownedPosts);
		return result;
	}

	// getters
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

	public Set<Album> getAlbums() {
		return Collections.unmodifiableSet(this.albums);
	}

	public Set<User> getFriends() {
		return Collections.unmodifiableSet(friends);
	}

	public Set<Post> getLikedPosts() {
		return Collections.unmodifiableSet(likedPosts);
	}

	public Set<Post> getSharedPosts() {
		return Collections.unmodifiableSet(sharedPosts);
	}

	public Set<Post> getOwnedPosts() {
		Set<Post> result = new TreeSet<Post>((o1, o2) -> {
			return o2.getCreated().compareTo(o1.getCreated());
		});
		result.addAll(this.ownedPosts);

		return Collections.unmodifiableSet(result);
	}

	public Picture getProfilePicture() {
		return this.profilePicture;
	}

	public String getProfilePath() {
		if (this.profilePicture == null || this.profilePicture.getName().equals("./images/default-pic.png")) {
			return "./images/default-pic.png";
		} else {
			return "images/" + this.email + "/ProfilePictures/" + this.profilePicture.getName();
		}
	}

	// setters
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

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setProfilePicture(Picture pic) {
		if (pic != null) {
			this.profilePicture = pic;
		}
	}

	public Picture getBgPicture() {
		return bgPicture;
	}

	public void setBgPicture(Picture bgPicture) {
		if (bgPicture != null) {
			this.bgPicture = bgPicture;
		}
	}

	public String getBgPath() {
		if (this.bgPicture == null || this.bgPicture.getName().equals("./images/backgrounds/background-1.jpg")) {
			return "./images/backgrounds/background-1.jpg";
		} else {
			return "images/" + this.email + "/BgPictures/" + this.bgPicture.getName();
		}
	}

	public void removeLike(Post p) {
		likedPosts.remove(p);
	}
	
	public void removeAllFriends(){
		friends.clear();
	}
	public void removeAllFollowers(){
		befriendedBy.clear();
	}
	public boolean checkAlbumByTitle(String title){
		for(Album a : this.albums){
			if(a.getTitle().equals(title)){
				return true;
			}
		}
		
		return false;
	}
}
