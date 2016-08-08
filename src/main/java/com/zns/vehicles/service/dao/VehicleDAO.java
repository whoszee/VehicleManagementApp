package com.zns.vehicles.service.dao;

import java.util.ArrayList;

import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.RetrievalRequest;
import com.zns.vehicles.model.RetrievalResponse;
import com.zns.vehicles.model.Truck;

public interface VehicleDAO {

	void saveVehicle(final Car request);
	void saveVehicle(final Motorcycle request);
	void saveVehicle(final Truck request);

	RetrievalResponse retrieveVehiclesForUser(final RetrievalRequest request);
}
