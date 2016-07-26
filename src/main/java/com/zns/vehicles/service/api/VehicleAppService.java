package com.zns.vehicles.service.api;

import com.zns.vehicles.model.CreateUserRequest;
import com.zns.vehicles.model.UserResponse;

public interface VehicleAppService {

	void createUser(CreateUserRequest userRequest);
}
