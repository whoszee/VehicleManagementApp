package com.zns.vehicles.service.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


@Path("/user")
public class UserService {
	
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
}
