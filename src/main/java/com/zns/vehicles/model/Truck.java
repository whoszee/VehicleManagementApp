package com.zns.vehicles.model;

public class Truck extends Car {

	private String vehicleClassification;

	public String getVehicleClassification() {
		return vehicleClassification;
	}

	public void setVehicleClassification(String vehicleClassification) {
		this.vehicleClassification = vehicleClassification;
	}

	@Override
	public String toString() {
		return "Truck [vehicleClassification=" + vehicleClassification + ", toString()=" + super.toString()
				+ ", get_id()=" + get_id() + ", getVehicleType()=" + getVehicleType() + ", getUsername()="
				+ getUsername() + ", getMake()=" + getMake() + ", getModel()=" + getModel() + ", getYear()=" + getYear()
				+ ", getExteriorColor()=" + getExteriorColor() + ", getInteriorColor()=" + getInteriorColor()
				+ ", getDoors()=" + getDoors() + ", getMileage()=" + getMileage() + ", getDrivetrain()="
				+ getDrivetrain() + ", getLicenseClass()=" + getLicenseClass() + ", getTransmission()="
				+ getTransmission() + ", getCylinderCount()=" + getCylinderCount() + ", getFuelType()=" + getFuelType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
