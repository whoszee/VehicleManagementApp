package com.zns.vehicles.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zns.vehicles.model.CreateUserRequest;

public class RequestDeserializer {

	private Logger log = LoggerFactory.getLogger(getClass());
	private CreateUserRequest request;
	public CreateUserRequest convertRequest(String json) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			request = mapper.readValue(json, CreateUserRequest.class);
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
}