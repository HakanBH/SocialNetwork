package com.facebook.POJO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLogin {

	@NotNull
	@Size(min=1)
	private String password;

	@NotNull
	@Size(min=1)
	private String email;
	
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserLogin [password=" + password + ", email=" + email + "]";
	}
}
