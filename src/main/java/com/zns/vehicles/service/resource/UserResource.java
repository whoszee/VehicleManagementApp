package com.zns.vehicles.service.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
import com.zns.vehicles.model.User;
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
	private User request;
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

	// CREATE NEW USER ENTRY
	// INPUT >>
	// BODY : USER JSON OBJECT
	@Path("/create")
	@POST
	public String createNewUser(@RequestBody String userRequest) {

		log.info("Creating new user... >>>>>>>>> ");
		return service.createUser(reqDeserializer.convertUserRequest(userRequest));
	}

	// CREATE CAR ENTRY FOR SPECIFIED USER
	// INPUT >>
	// PATH : USERNAME
	// BODY : CAR JSON OBJECT
	@Path("/{username}/vehicles/create/car")
	@POST
	public String createNewCar(@PathParam("username") String userName, @RequestBody String vehicleRequest) {

		log.info("Creating new car entry for >>>>>>>>>>>" + userName);
		return service.createVehicle(userName, reqDeserializer.convertCarRequest(vehicleRequest));
	}

	// CREATE TRUCK ENTRY FOR SPECIFIED USER
	// INPUT >>
	// PATH : USERNAME
	// BODY : TRUCK JSON OBJECT
	@Path("/{username}/vehicles/create/truck")
	@POST
	public String createNewTruck(@PathParam("username") String userName, @RequestBody String vehicleRequest) {

		log.info("Creating new truck entry for >>>>>>>>>>>" + userName);
		return service.createVehicle(userName, reqDeserializer.convertTruckRequest(vehicleRequest));
	}

	// CREATE MOTORCYCLE ENTRY FOR SPECIFIED USER
	// INPUT >>
	// PATH : USERNAME
	// BODY : MOTORCYCLE JSON OBJECT
	@Path("/{username}/vehicles/create/motorcycle")
	@POST
	public String createNewMotorcycle(@PathParam("username") String userName, @RequestBody String vehicleRequest) {

		log.info("Creating new motorcycle entry for >>>>>>>>>>>" + userName);
		return service.createVehicle(userName, reqDeserializer.convertMotoRequest(vehicleRequest));
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PENDING <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
	// RETRIEVE SPECIFIED VEHICLES FOR SPECIFIED USER
	// INPUT >>
	// PATH : USERNAME
	// PATH : TYPE OF VEHICLE
	// ALL || CARS || TRUCKS || MOTORCYCLES
	@Path("/{username}/vehicles/{vehicleType}")
	@GET
	@Produces("text/html")
	public String getVehiclesForUser(@PathParam("username") String userName, @PathParam("vehicleType") String type) {

		if (type.equalsIgnoreCase("all")) {
			log.info("Retrieving all vehicles for >>>>>>>>" + userName);
			return null;
			
		} else {

			log.info("Retrieving all " + type.toLowerCase() + "'s for >>>>>>>>" + userName);
			return null;
		}
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PENDING <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
	// UPDATE A SPECIFIC VEHICLE FOR SPECIFIED USER
	// INPUT >>
	// PATH : USERNAME
	// PATH : VEHICLE ID
	@Path("/{username}/vehicles/{vehicleId}/update")
	@PUT
	public String updateVehicleForUser(@PathParam("username") String userName,
			@PathParam("vehicleId") String vehicleId) {

		log.info(">>> UPDATING vehicle no: " + vehicleId + " for >>>>>>>> " + userName);
		return null;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PENDING <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
	// DELETE SPECIFIC VEHICLE FOR SPECIFIED USER
	// INPUT >>
	// PATH : USERNAME
	// PATH : VEHICLE ID
	@Path("/{username}/vehicles/{vehicleId}/delete")
	@DELETE
	public String deleteVehicleForUser(@PathParam("username") String userName,
			@PathParam("vehicleId") String vehicleId) {

		log.info(">>> DELETING vehicle no: " + vehicleId + " for >>>>>>>> " + userName.toUpperCase());
		return null;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PENDING <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
	// DELETE ALL VEHICLES FOR SPECIFIED USER
	// INPUT >>
	// PATH : USERNAME
	@Path("/{username}/vehicles/delete")
	@GET
	public String deleteAllVehiclesForUser(@PathParam("username") String userName) {

		log.info(">>> DELETING ALL VEHICLES FOR >>>>>>>> " + userName.toUpperCase());
		return null;
	}
}
