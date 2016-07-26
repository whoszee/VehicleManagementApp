package com.zns.vehicles.model;

import com.owlike.genson.annotation.JsonProperty;

public class CreateUserRequest {

	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("personFName")
	private String personFName;
	@JsonProperty("personLName")
	private String personLName;
	@JsonProperty("personDOB")
	private String personDOB;
	@JsonProperty("personEmail")
	private String personEmail;
	@JsonProperty("personZip")
	private String personZipCode;

	public String getPersonZipCode() {
		return personZipCode;
	}

	public void setPersonZipCode(String personZipCode) {
		this.personZipCode = personZipCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonFName() {
		return personFName;
	}

	public void setPersonFName(String personFName) {
		this.personFName = personFName;
	}

	public String getPersonLName() {
		return personLName;
	}

	public void setPersonLName(String personLName) {
		this.personLName = personLName;
	}

	public String getPersonDOB() {
		return personDOB;
	}

	public void setPersonDOB(String personDOB) {
		this.personDOB = personDOB;
	}

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
}
