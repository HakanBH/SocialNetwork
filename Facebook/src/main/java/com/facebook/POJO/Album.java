package com.facebook.POJO;

import java.util.HashSet; 
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "albums")
public class Album extends BaseEntity {

	@Column(columnDefinition="VARCHAR(25)")
	private String title;

	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
		@JoinColumn(name = "album_id")
	private Set<Picture> pictures;

	public Album() {
		pictures = new HashSet<Picture>();
	}

	public Album(String title, User owner) {
		pictures = new HashSet<Picture>();
		setTitle(title);
		setOwner(owner);
	}

	public void addPicture(Picture pic) {
		pictures.add(pic);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "Album [title=" + title + ", owner=" + owner + ", pictures=" + pictures + "]";
	}
}
