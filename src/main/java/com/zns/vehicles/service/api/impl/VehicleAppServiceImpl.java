package com.zns.vehicles.service.api.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zns.vehicles.model.CreateUserRequest;
import com.zns.vehicles.model.UserResponse;
import com.zns.vehicles.service.api.VehicleAppService;
import com.zns.vehicles.service.dao.UserDAO;
import com.zns.vehicles.service.validator.VehicleAppValidator;

public class VehicleAppServiceImpl implements VehicleAppService {

	private Logger log = LoggerFactory.getLogger(getClass());

	VehicleAppValidator validator;

	UserDAO dao;

	@Override
	public void createUser(CreateUserRequest userRequest) {

		if (validator.validateNewUser(userRequest)) {
			log.debug("Validation for new user details has completed successfully.");
			dao.saveUser(userRequest);
			log.debug("Request for "+userRequest.getUsername() +" has been submitted for persistence...");
		}
	}

}
