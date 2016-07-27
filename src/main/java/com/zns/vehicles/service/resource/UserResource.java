package com.zns.vehicles.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.sun.jersey.spi.inject.Inject;
import com.zns.vehicles.model.CreateUserRequest;
import com.zns.vehicles.service.api.VehicleAppService;
import com.zns.vehicles.service.api.impl.VehicleAppServiceImpl;
import com.zns.vehicles.util.RequestDeserializer;


@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserResource {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private VehicleAppService service = (VehicleAppService) new VehicleAppServiceImpl();
	private CreateUserRequest request;
	RequestDeserializer reqDeserializer = new RequestDeserializer();

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
	// @Produces("text/html")
	public void createNewUser(@RequestBody String userRequest) {

		log.info("Creating new user... >>>>>>>>> ");
		
		log.info("Incoming request : " + reqDeserializer.convertRequest(userRequest).toString()
				);
		service.createUser(reqDeserializer.convertRequest(userRequest));
		//return reqDeserializer.convertRequest(userRequest).toString();
	}
}
