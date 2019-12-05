package com.royben.photoapp.api.users.ui.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull(message="First name cannot be null")
	@Size(min = 3,message = "Minium 3 characters")
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Size(min = 8, max = 16, message = "8 to 16")
	private String password;
	@NotNull
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
