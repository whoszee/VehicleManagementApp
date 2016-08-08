package com.zns.vehicles.model;

public class User {

	private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

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
