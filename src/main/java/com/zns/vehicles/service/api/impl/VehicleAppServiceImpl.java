package com.zns.vehicles.service.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.model.User;
import com.zns.vehicles.service.api.VehicleAppService;
import com.zns.vehicles.service.dao.UserDAO;
import com.zns.vehicles.service.dao.VehicleDAO;
import com.zns.vehicles.service.dao.impl.UserDAOImpl;
import com.zns.vehicles.service.dao.impl.VehicleDAOImpl;
import com.zns.vehicles.service.validator.VehicleAppValidator;

public class VehicleAppServiceImpl implements VehicleAppService {

	private Logger log = LoggerFactory.getLogger(getClass());

	VehicleAppValidator validator = new VehicleAppValidator();

	UserDAO dao = new UserDAOImpl();
	VehicleDAO vehicleDAO = new VehicleDAOImpl();

	@Override
	public void createUser(User userRequest) {

		log.info("submitting create user request for validation >>>>>>>>>>>>>>><<<<<<<<<<<<<<");
		
		if (validator.validateNewUser(userRequest)) {
			log.info("Validation for new user details has completed successfully and user will be created.");
			dao.saveUser(userRequest);
			log.info("Persistence for " + userRequest.getUsername() + " has been completed successfully...");
		} else {
			log.error("New User Validation has failed...");
		}

	}

	@Override
	public void createVehicle(Car vehicleRequest) {
		// TODO Auto-generated method stub
		log.info("submitting create car request for validation >>>>>>>>>>>>>>><<<<<<<<<<<<<<");
		if (validator.validateCar(vehicleRequest)){
			log.info("Validation for new car entry has completed successfully");
			vehicleDAO.saveVehicle(vehicleRequest);
		}
	}

	@Override
	public void createVehicle(Motorcycle vehicleRequest) {
		// TODO Auto-generated method stub
		log.info("submitting create motorcycle request for validation >>>>>>>>>>>>>>><<<<<<<<<<<<<<");
		if (validator.validateMotorcycle(vehicleRequest)){
			log.info("Validation for new motorcycle entry has completed successfully");
			vehicleDAO.saveVehicle(vehicleRequest);
		}
	}

	@Override
	public void createVehicle(Truck vehicleRequest) {
		// TODO Auto-generated method stub
		log.info("submitting create truck request for validation >>>>>>>>>>>>>>><<<<<<<<<<<<<<");
		if (validator.validateTruck(vehicleRequest)){
			log.info("Validation for new truck entry has completed successfully");
			vehicleDAO.saveVehicle(vehicleRequest);
		}
	}

}
