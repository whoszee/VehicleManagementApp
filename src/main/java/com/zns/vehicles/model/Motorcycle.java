package com.zns.vehicles.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Motorcycle {

	@Override
	public String toString() {
		return "Motorcycle [username=" + username + ", vehicleType=" + vehicleType + ", make=" + make + ", model="
				+ model + ", year=" + year + ", color=" + color + ", licenseClass=" + licenseClass + ", transmission="
				+ transmission + ", fuelType=" + fuelType + ", mileage=" + mileage + ", _id=" + _id + "]";
	}

	private String username;
	private String vehicleType;

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String make;
	private String model;
	private Integer year;
	private String color;
	private String licenseClass;
	private String transmission;
	private String fuelType;
	private Integer mileage;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLicenseClass() {
		return licenseClass;
	}

	public void setLicenseClass(String licenseClass) {
		this.licenseClass = licenseClass;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}
