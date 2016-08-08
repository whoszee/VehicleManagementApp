package com.zns.vehicles.service.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.RetrievalRequest;
import com.zns.vehicles.model.RetrievalResponse;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.model.User;
import com.zns.vehicles.service.api.VehicleAppService;
import com.zns.vehicles.service.dao.SequenceDAO;
import com.zns.vehicles.service.dao.UserDAO;
import com.zns.vehicles.service.dao.VehicleDAO;
import com.zns.vehicles.service.dao.impl.SequenceDAOImpl;
import com.zns.vehicles.service.dao.impl.UserDAOImpl;
import com.zns.vehicles.service.dao.impl.VehicleDAOImpl;
import com.zns.vehicles.service.validator.VehicleAppValidator;

public class VehicleAppServiceImpl implements VehicleAppService {

	private final static String CAR = "car";
	private final static String TRUCK = "truck";
	private final static String MOTO = "motorcycle";

	private Logger log = LoggerFactory.getLogger(getClass());

	private VehicleAppValidator validator = new VehicleAppValidator();

	private SequenceDAO sequenceDao = new SequenceDAOImpl();

	UserDAO userDao = new UserDAOImpl();
	VehicleDAO vehicleDAO = new VehicleDAOImpl();

	@Override
	public String createUser(User userRequest) {

		if (validator.validateNewUser(userRequest)) {
			log.info("Validation for new user details has completed successfully and user will be created.");
			userDao.saveUser(userRequest);
			return ("Persistence for " + userRequest.get_id() + " has been completed successfully...");
		} else {
			return ("Validation has failed and user account will not be created");
		}
	}

	@Override
	public String createVehicle(String user, Car vehicleRequest) {

		vehicleRequest.setUsername(user);
		vehicleRequest.setVehicleType(CAR);

		try {
			vehicleRequest.set_id(validator.vehicleIdValidator(sequenceDao.getNextSequenceId("vehicleId").toString()));

		} catch (Exception e) {

			log.error("Error getting next sequence id for this vehicle");
			e.printStackTrace();
		}

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

		vehicleRequest.setUsername(user);
		vehicleRequest.setVehicleType(MOTO);

		try {
			vehicleRequest.set_id(validator.vehicleIdValidator(sequenceDao.getNextSequenceId("vehicleId").toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error getting next sequence id for this vehicle");
			e.printStackTrace();
		}

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

		vehicleRequest.setUsername(user);
		vehicleRequest.setVehicleType(TRUCK);

		try {
			vehicleRequest.set_id(validator.vehicleIdValidator(sequenceDao.getNextSequenceId("vehicleId").toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error getting next sequence id for this vehicle");
			e.printStackTrace();
		}

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

	@Override
	public RetrievalResponse getVehiclesForUser(RetrievalRequest request) {
		// TODO Auto-generated method stub
		RetrievalResponse finalResponse = new RetrievalResponse();
		log.info("checking if username exists for::::::::: " + request.getUserName());
		if (userDao.checkUsernameExists(request.getUserName())) {
			log.info("validating vehicle type");
			if (validator.validateVehicleType(request.getVehicleType())) {

				try {
					finalResponse = vehicleDAO.retrieveVehiclesForUser(request);
					log.info("FINAL RESPONSE ::::::::::::");

					log.info("FINAL RESPONSE>>>> " + finalResponse.toString());
				} catch (NullPointerException e) {
					log.error("null pointer >>>>>>>>>>>>> " + e);
					e.printStackTrace();
				}

				return finalResponse;

			} else {
				log.error("Requested vehicle type is invalid.");
				return null;
			}
		} else {
			log.error("The requested username does not exist.");
			return null;
		}
	}
}
