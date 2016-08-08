package com.zns.vehicles.service.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.model.User;
import com.zns.vehicles.service.dao.UserDAO;
import com.zns.vehicles.service.dao.impl.UserDAOImpl;

public class VehicleAppValidator {

	private Logger log = LoggerFactory.getLogger(getClass());

	UserDAO dao = new UserDAOImpl();

	private static final String CAR = "car";
	private static final String TRUCK = "truck";
	private static final String MOTO = "motorcycle";
	private static final String ALL = "all";

	public boolean validateNewUser(User userRequest) {

		try {

			if (!usernameValidation(userRequest.get_id()) && validateName(userRequest.getPersonLName())
					&& validateName(userRequest.getPersonFName()) && validatePassword(userRequest.getPassword())
					&& validateZip(userRequest.getPersonZipCode()) && isValidEmailAddress(userRequest.getPersonEmail())
					&& validateDate(userRequest.getPersonDOB())) {
				log.info("user data validation completed successfully");
				return true;
			}
		} catch (Exception ex) {
			log.error("Input validation failed.");
		}
		log.info("New user data validation has failed and new user will not be created.");
		return false;
	}

	public boolean validateCar(Car request) {

		try {
			if (request != null && !request.getMake().isEmpty() && request.getCylinderCount() > 1
					&& request.getDoors() > 1 && !request.getDrivetrain().isEmpty()
					&& !request.getExteriorColor().isEmpty() && !request.getInteriorColor().isEmpty()
					&& !request.get_id().isEmpty() && !request.getVehicleType().isEmpty()) {
				return true;
			}
		} catch (NullPointerException e) {
			log.error("Mandatory required fields were blank...");
			return false;
		}
		return false;
	}

	public boolean validateTruck(Truck request) {

		try {
			if (request != null && !request.getMake().isEmpty() && request.getCylinderCount() > 1
					&& request.getDoors() > 1 && !request.getDrivetrain().isEmpty()
					&& !request.getExteriorColor().isEmpty() && !request.getInteriorColor().isEmpty()
					&& !request.getVehicleClassification().isEmpty() && usernameValidation(request.getUsername())
					&& !request.get_id().isEmpty() && !request.getVehicleType().isEmpty()) {
				return true;
			}
		} catch (NullPointerException e) {
			log.error("Mandatory required fields were blank...");
			return false;
		}
		return false;
	}

	public boolean validateMotorcycle(Motorcycle request) {

		try {
			if (request != null && !request.getLicenseClass().isEmpty() && !request.getMake().isEmpty()
					&& !request.getModel().isEmpty() && request.getUsername() != null
					&& usernameValidation(request.getUsername()) && !request.get_id().isEmpty()
					&& !request.getVehicleType().isEmpty()) {
				return true;
			}
		} catch (NullPointerException e) {
			log.error("Mandatory required fields were blank...");
			return false;
		}
		return false;
	}

	private boolean validateName(String name) {

		if (!name.isEmpty() && name.length() > 4) {
			return true;
		}
		log.error("Name entry of " + name + " requires more than 4 characters.");
		return false;
	}

	private boolean validatePassword(String field) {
		if (field.length() > 3 && field.length() < 9) {
			return true;
		}
		log.error("Length for password should be between 4 and 8 characters");
		return false;
	}

	private boolean validateZip(String field) {
		if (field.length() == 5) {
			return true;
		}
		log.error("Invalid zip code");
		return false;
	}

	// returns true if username exists in db
	private boolean usernameValidation(String userName) {

		if (dao.checkUsernameExists(userName)) {
			log.error("Username already exists, please choose another one...");
			return true;
		} else {
			log.info("username: " + userName + " is unique");
			return false;
		}

	}

	private boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	private boolean validateDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			sdf.parse(date);
			return true;
		} catch (ParseException ex) {
			log.error("Invalid DOB. Should be in 'dd-MM-yyyy' format.");
			return false;
		}
	}

	public boolean validateVehicleType(String vehicleType) {

		if (vehicleType.equalsIgnoreCase(ALL) || vehicleType.equalsIgnoreCase(CAR) || vehicleType.equalsIgnoreCase(TRUCK) || vehicleType.equalsIgnoreCase(MOTO)) {
			log.info("Vehicle type is valid");
			return true;
		} else {
			return false;
		}
	}
	
	public String vehicleIdValidator(String currentVehicleId) {
		String newVehicleId = null;
		if (currentVehicleId.endsWith(".0")) {
			newVehicleId = (currentVehicleId.substring(0, currentVehicleId.length() - 2));
		}
		return newVehicleId;
	}
}
