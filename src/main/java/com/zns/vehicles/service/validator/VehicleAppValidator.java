package com.zns.vehicles.service.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.model.User;

public class VehicleAppValidator {

	private Logger log = LoggerFactory.getLogger(getClass());

	public boolean validateNewUser(User userRequest) {

		log.info("inside validator>>>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			validateName(userRequest.getPersonFName());
			validateName(userRequest.getPersonLName());
			validatePassword(userRequest.getPassword());
			isUsernameExists(userRequest.getUsername());
			validateZip(userRequest.getPersonZipCode());
			isValidEmailAddress(userRequest.getPersonEmail());
			validateDate(userRequest.getPersonDOB());
			return true;
		} catch (Exception ex) {
			log.error("Input validation failed.");
		}
		return false;
	}

	public boolean validateCar(Car request) {

		if (request != null && !request.getMake().isEmpty() && request.getCylinderCount() > 1 && request.getDoors() > 1
				&& !request.getDrivetrain().isEmpty() && !request.getExteriorColor().isEmpty()
				&& !request.getInteriorColor().isEmpty()) {

			return true;
		}

		return false;
	}

	public boolean validateTruck(Truck request) {

		if (request != null && !request.getMake().isEmpty() && request.getCylinderCount() > 1 && request.getDoors() > 1
				&& !request.getDrivetrain().isEmpty() && !request.getExteriorColor().isEmpty()
				&& !request.getInteriorColor().isEmpty() && !request.getVehicleClassification().isEmpty()) {

			return true;

		}

		return false;
	}

	public boolean validateMotorcycle(Motorcycle request){
		
		if (request!=null && !request.getLicenseClass().isEmpty() && !request.getMake().isEmpty() && !request.getModel().isEmpty()) {
			return true;
		}
		
		return false;
	}

	private boolean validateName(String name) {

		if (!name.isEmpty() && name.length() > 5) {
			return true;
		}
		log.error("Name entry of " + name + " did not pass validation. Try again...");
		return false;
	}

	private boolean validatePassword(String field) {
		if (field.length() > 3 && field.length() < 8) {
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

	private boolean isUsernameExists(String userName) {
		// TODO check mongo to see if this value exists in username field in
		// user collection
		return false;
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
}
