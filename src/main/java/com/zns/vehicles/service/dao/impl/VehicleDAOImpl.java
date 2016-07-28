package com.zns.vehicles.service.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.service.dao.VehicleDAO;

public class VehicleDAOImpl implements VehicleDAO{

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public void saveVehicle(Car request) {
		// TODO Auto-generated method stub
		log.info("Persisting your car entry");
	}

	@Override
	public void saveVehicle(Motorcycle request) {
		// TODO Auto-generated method stub
		log.info("Persisting your motorcycle entry");
		
	}

	@Override
	public void saveVehicle(Truck request) {
		// TODO Auto-generated method stub
		log.info("Persisting your truck entry");
		
	}

}
