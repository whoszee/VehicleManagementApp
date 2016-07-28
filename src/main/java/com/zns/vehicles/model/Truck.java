package com.zns.vehicles.model;

public class Truck extends Car{

	private String vehicleClassification;

	@Override
	public String toString() {
		return "Truck [vehicleClassification=" + vehicleClassification + "]";
	}

	public String getVehicleClassification() {
		return vehicleClassification;
	}

	public void setVehicleClassification(String vehicleClassification) {
		this.vehicleClassification = vehicleClassification;
	}
	
}
