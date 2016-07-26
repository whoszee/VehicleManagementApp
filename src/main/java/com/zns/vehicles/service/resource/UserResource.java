package com.zns.vehicles.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.springframework.web.bind.annotation.RequestBody;

import com.zns.vehicles.model.CreateUserRequest;
import com.zns.vehicles.model.UserResponse;
import com.zns.vehicles.service.api.VehicleAppService;
import com.zns.vehicles.service.validator.VehicleAppValidator;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserResource {

	VehicleAppService service;

	@Path("/hello")
	@GET
	@Produces("text/html")
	public String getUser() {
		return "hello world";
	}

	@Path("/zeeshan")
	@GET
	@Produces("text/html")
	public String getUsers() {
		return "hello zeeshan";
	}

	@Path("/query")
	@GET
	@Produces("text/html")
	public String getUsersWparam(@Context UriInfo info) {
		String param = info.getQueryParameters().getFirst("name");
		return "the name is " + param;
	}

	@Path("/{username}")
	@GET
	@Produces("text/html")
	public String getUser(@PathParam("username") String userName) {

		return "Welcome to " + userName + "'s profile page...";
	}

	@Path("/{username}/vehicles")
	@GET
	@Produces("text/html")
	public String getUserVehicles(@PathParam("username") String userName) {

		return "Welcome to " + userName + "'s vehicle listing page...";
	}

	@Path("/create")
	@POST
	//@Produces("text/html")
	public void createNewUser(@RequestBody CreateUserRequest userRequest) {

		service.createUser(userRequest);

	}
}
