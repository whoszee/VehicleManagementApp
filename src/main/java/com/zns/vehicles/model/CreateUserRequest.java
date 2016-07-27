package com.zns.vehicles.model;

public class CreateUserRequest {

	
	private String username;
	
	private String password;
	
	private String personFName;
	
	private String personLName;
	
	private String personDOB;
	
	private String personEmail;
	
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
	
	@Override
	public String toString() {
		return "CreateUserRequest [username=" + username + ", password=" + password + ", personFName=" + personFName
				+ ", personLName=" + personLName + ", personDOB=" + personDOB + ", personEmail=" + personEmail
				+ ", personZipCode=" + personZipCode + "]";
	}
}
