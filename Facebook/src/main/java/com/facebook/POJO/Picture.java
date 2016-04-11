package com.facebook.POJO;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pictures")

public class Picture extends BaseEntity {
	@Column(name = "name", columnDefinition = "VARCHAR(100)")
	private String name;

	@ManyToOne
	@JoinColumn(name = "album_id", nullable = false)
	@JsonIgnore
	private Album album;

	public Picture() {
	}

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

	@Override
	public boolean equals(Object o1) {
		if (o1 instanceof Picture) {
			return this.getName().equals(((Picture) o1).getName());
		}
		return false;
	}

	@Override
	public int hashCode() {

		return Integer.valueOf(this.getId());
	}
}
