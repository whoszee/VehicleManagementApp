package com.zns.vehicles.service.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


@Path("/user")
public class UserResource {
	
	@Path("/hello")
	@GET
	@Produces("text/html")
	public String getUser()  {
		return "hello world";
	}
	
	@Path("/zeeshan")
	@GET
	@Produces("text/html")
	public String getUsers()  {
		return "hello zeeshan";
	}
	
	@Path("/query")
	@GET
	@Produces("text/html")
	public String getUsersWparam(@Context UriInfo info)  {
		String param = info.getQueryParameters().getFirst("name");
		return "the name is "+param;
	}
	
	@Path("/{username}")
	@GET
	@Produces("text/html")
	public String getUser(@PathParam("username") String userName)  {
		
		return "Welcome to "+userName+"'s profile page...";
	}
	
	@Path("/{username}/vehicles")
	@GET
	@Produces("text/html")
	public String getUserVehicles(@PathParam("username") String userName)  {
		
		return "Welcome to "+userName+"'s vehicle listing page...";
	}
}
