package com.facebook.POJO;

import javax.persistence.*;

@Entity
@Table(name = "pictures")

public class Picture extends BaseEntity {
	@Column(name = "name", columnDefinition = "VARCHAR(255)")
	private String name;

	@ManyToOne
	@JoinColumn(name = "album_id", nullable=false)
	private Album album;
	
	public Picture() {}

	public Picture(String name) {
		setName(name);
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Album getAlbum() {
		return album;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
