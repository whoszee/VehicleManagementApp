package com.zns.vehicles.service.api;

import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.model.User;

public interface VehicleAppService {
	
	void createUser(User userRequest);
	
	void createVehicle (Car vehicleRequest);
	void createVehicle (Motorcycle vehicleRequest);
	void createVehicle (Truck vehicleRequest);
	
}
