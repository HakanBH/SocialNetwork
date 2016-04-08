package com.facebook.POJO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity {

	@Column(columnDefinition = "VARCHAR(25)")
	private String title;

	@ManyToOne
	@JoinColumn(name = "owner", nullable = false)
	private User owner;

	@OneToMany(orphanRemoval=true, fetch = FetchType.EAGER, mappedBy = "album")
	private List<Picture> pictures = new ArrayList<Picture>();

	public Album() {}

	public Album(String title, User owner) {
		setTitle(title);
		setOwner(owner);
	}

	public void addPicture(Picture pic) {
		pictures.add(pic);
	}
	
	public void removePicture(Picture pic){
		pictures.remove(pic);
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
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
