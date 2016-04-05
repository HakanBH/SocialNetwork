	package com.facebook.POJO;

import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user_info")
public class UserInfo {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	private int userId;

	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	@Column(columnDefinition="VARCHAR(25)")
	private String country;

	@Column(columnDefinition="VARCHAR(25)")
	private String city;

	@Column(columnDefinition="VARCHAR(50)")
	private String address;

	@Column
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@Column(columnDefinition="VARCHAR(10)")
	private String gender;

	@Column(columnDefinition="VARCHAR(12)")
	private String mobilePhone;

	@Column
	private String relationshipStatus;

	public UserInfo() {
	}

	public UserInfo(UserInfo ud){
		this(ud.getCountry(), ud.getCity(), ud.getAddress(), ud.getBirthday(), ud.getGender(),
				ud.getMobilePhone(), ud.getRelationshipStatus());
	}
	
	public UserInfo(String country, String city, String address, Date birthday, String gender, String mobilePhone,
			String inRelationship) {
		setCountry(country);
		setCity(city);
		setAddress(address);
		setBirthday(birthday);
		setGender(gender);
		setMobilePhone(mobilePhone);
		setRelationshipStatus(inRelationship);
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getGender() {
		return gender;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public void copy(UserInfo other){
		setAddress(other.getAddress());
		setCity(other.getCity());
		setCountry(other.getCountry());
		setBirthday(other.getBirthday());
		setGender(other.getGender());
		setMobilePhone(other.getMobilePhone());
		setRelationshipStatus(other.getRelationshipStatus());
	}
}
