package com.zns.vehicles.service.dao;

import com.zns.vehicles.model.CreateUserRequest;

public interface UserDAO {

	void saveUser (final CreateUserRequest userRequest);
}
