package com.zns.vehicles.service.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zns.vehicles.model.CreateUserRequest;
import com.zns.vehicles.service.api.VehicleAppService;
import com.zns.vehicles.service.dao.UserDAO;
import com.zns.vehicles.service.dao.impl.UserDAOImpl;
import com.zns.vehicles.service.validator.VehicleAppValidator;

public class VehicleAppServiceImpl implements VehicleAppService {

	private Logger log = LoggerFactory.getLogger(getClass());

	
	VehicleAppValidator validator = new VehicleAppValidator();

	UserDAO dao = new UserDAOImpl();

	@Override
	public void createUser(CreateUserRequest userRequest) {

		log.info("submitting request for validation >>>>>>>>>>>>>>><<<<<<<<<<<<<<");
		
		if (validator.validateNewUser(userRequest)) {
			log.info("Validation for new user details has completed successfully.");
			dao.saveUser(userRequest);
			log.info("Request for " + userRequest.getUsername() + " has been submitted for persistence...");
		} else {
			log.error("Validation has failed...");
		}
			
	}

}
