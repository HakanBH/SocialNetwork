package com.facebook.POJO;

import javax.persistence.*;

@Entity
@Table(name = "pictures", uniqueConstraints = @UniqueConstraint(columnNames = { "path" }) )

public class Picture extends BaseEntity {
	@Column(name = "path", columnDefinition = "VARCHAR(100)", nullable = false)
	private String path;

	@Column(name = "name", columnDefinition = "VARCHAR(50)")
	private String name;

	@ManyToOne
	@JoinColumn(name = "album_id", referencedColumnName="id")
	private Album album;

	public Picture() {
	}

	public Picture(String path) {
		setPath(path);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String picturePath) {
		this.path = picturePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
