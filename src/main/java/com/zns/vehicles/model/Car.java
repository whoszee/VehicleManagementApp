package com.zns.vehicles.model;

public class Car {

	private String make;
	private String model;
	private Integer year;
	private String exteriorColor;
	private String interiorColor;
	private Integer doors;
	private Integer mileage;
	private String drivetrain;
	private String licenseClass;
	private String transmission;
	private Integer cylinderCount;
	private String fuelType;

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

	public String getExteriorColor() {
		return exteriorColor;
	}

	public void setExteriorColor(String exteriorColor) {
		this.exteriorColor = exteriorColor;
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}

	public Integer getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getDrivetrain() {
		return drivetrain;
	}

	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
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

	public Integer getCylinderCount() {
		return cylinderCount;
	}

	public void setCylinderCount(Integer cylinderCount) {
		this.cylinderCount = cylinderCount;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + ", exteriorColor=" + exteriorColor
				+ ", interiorColor=" + interiorColor + ", doors=" + doors + ", mileage=" + mileage + ", drivetrain="
				+ drivetrain + ", licenseClass=" + licenseClass + ", transmission=" + transmission + ", cylinderCount="
				+ cylinderCount + ", fuelType=" + fuelType + "]";
	}
}
