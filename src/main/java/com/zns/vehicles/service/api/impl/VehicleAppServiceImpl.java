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

	UserDAO userDao = new UserDAOImpl();
	VehicleDAO vehicleDAO = new VehicleDAOImpl();

	@Override
	public String createUser(User userRequest) {

		if (validator.validateNewUser(userRequest)) {
			log.info("Validation for new user details has completed successfully and user will be created.");
			userDao.saveUser(userRequest);
			return ("Persistence for " + userRequest.getUsername() + " has been completed successfully...");
		} else {
			return ("Validation has failed and user account will not be created");
		}
	}

	@Override
	public String createVehicle(String user, Car vehicleRequest) {
		// TODO Auto-generated method stub
		vehicleRequest.setUserName(user);
		log.info("checking if username exists for::::::::: " + user);

		if (userDao.checkUsernameExists(user)) {
			log.info("submitting create car request for validation");

			if (validator.validateCar(vehicleRequest)) {
				log.info("Validation for new car entry has completed successfully");
				vehicleDAO.saveVehicle(vehicleRequest);
				return "Car entry for " + vehicleRequest.getMake() + " " + vehicleRequest.getModel()
						+ " has persisted successfully for " + user;
			} else {
				return "Data for car entry did not pass validation... this car will not be added.";
			}
		} else {
			return "Did not find " + user + " in the db... this car cannot be added.";
		}
	}

	@Override
	public String createVehicle(String user, Motorcycle vehicleRequest) {
		// TODO Auto-generated method stub
		vehicleRequest.setUserName(user);
		log.info("checking if username exists for::::::::: " + user);

		if (userDao.checkUsernameExists(user)) {
			log.info("submitting create moto request for validation");

			if (validator.validateMotorcycle(vehicleRequest)) {
				log.info("Validation for new motorcycle entry has completed successfully");
				vehicleDAO.saveVehicle(vehicleRequest);
				return "Moto entry for " + vehicleRequest.getMake() + " " + vehicleRequest.getModel()
						+ " has persisted successfully for " + user;
			} else {
				return "Data for moto entry did not pass validation... this motorcycle will not be added.";
			}
		} else {
			return "Did not find " + user + " in the db... this motorcycle cannot be added.";
		}
	}

	@Override
	public String createVehicle(String user, Truck vehicleRequest) {
		// TODO Auto-generated method stub
		vehicleRequest.setUserName(user);
		log.info("checking if username exists for::::::::: " + user);

		if (userDao.checkUsernameExists(user)) {
			log.info("submitting create moto request for validation");

			if (validator.validateTruck(vehicleRequest)) {
				log.info("Validation for new truck entry has completed successfully");
				vehicleDAO.saveVehicle(vehicleRequest);
				return "Truck entry for " + vehicleRequest.getMake() + " " + vehicleRequest.getModel()
						+ " has persisted successfully for " + user;
			} else {
				return "Data for truck entry did not pass validation... this truck will not be added.";
			}
		} else {
			return "Did not find " + user + " in the db... this truck cannot be added.";
		}
	}

}
