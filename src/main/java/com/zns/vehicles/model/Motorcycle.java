package com.zns.vehicles.model;

public class Motorcycle {

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
	
	@Override
	public String toString() {
		return "Motorcycle [make=" + make + ", model=" + model + ", year=" + year + ", color=" + color
				+ ", licenseClass=" + licenseClass + ", transmission=" + transmission + ", fuelType=" + fuelType
				+ ", mileage=" + mileage + "]";
	}
}
