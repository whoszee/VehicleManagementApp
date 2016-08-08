package com.zns.vehicles.service.api;

import java.util.ArrayList;

import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.RetrievalRequest;
import com.zns.vehicles.model.RetrievalResponse;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.model.User;

public interface VehicleAppService {
	
	String createUser(User userRequest);
	
	String createVehicle (String user, Car vehicleRequest);
	String createVehicle (String user, Motorcycle vehicleRequest);
	String createVehicle (String user, Truck vehicleRequest);

	RetrievalResponse getVehiclesForUser(final RetrievalRequest request);
}
