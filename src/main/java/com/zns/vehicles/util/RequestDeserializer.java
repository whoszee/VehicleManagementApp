package com.zns.vehicles.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.RetrievalResponse;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.model.User;

public class RequestDeserializer {

	private Logger log = LoggerFactory.getLogger(getClass());
	private User request;
	private Car carRequest = new Car();
	private Truck truckRequest;
	private Motorcycle motoRequest;
	
	public User convertUserRequest(String json) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			request = mapper.readValue(json, User.class);
		} catch (JsonGenerationException e) {
			log.error(e.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		}
		return request;
	}
	
	public Car convertCarRequest(String json) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			carRequest = mapper.readValue(json, Car.class);
		} catch (JsonGenerationException e) {
			log.error(e.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		}
		return carRequest;
	}
	
	public Truck convertTruckRequest(String json) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			truckRequest = mapper.readValue(json, Truck.class);
		} catch (JsonGenerationException e) {
			log.error(e.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		}
		return truckRequest;
	}
	
	public Motorcycle convertMotoRequest(String json) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			motoRequest = mapper.readValue(json, Motorcycle.class);
		} catch (JsonGenerationException e) {
			log.error(e.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		}
		return motoRequest;
	}
}
