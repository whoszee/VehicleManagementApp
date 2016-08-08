package com.zns.vehicles.model;

public class RetrievalRequest {

	private String userName;

	private String vehicleType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "RetrievalRequest [userName=" + userName + ", vehicleType=" + vehicleType + "]";
	}
}
