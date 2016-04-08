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
	
	 @Override
	    public boolean equals(Object o1) {


	        if(this.getName().equals(((Picture) o1).getName())){
	                return true;
	        }
	        return false;
	    }


	    @Override
	    public int hashCode() {

	        
	        return Integer.valueOf(this.getId());
	    }
}
