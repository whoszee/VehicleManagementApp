package com.zns.vehicles.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zns.vehicles.model.RetrievalResponse;

public class ResponseSerializer {

	public String convertResponse(RetrievalResponse response){

		ObjectMapper mapper = new ObjectMapper();

		try {
		    // convert user object to json string and return it 
		    return mapper.writeValueAsString(response);
		}

		  // catch various errors
		  catch (JsonGenerationException e) {
		    e.printStackTrace();
		} 
		  catch (JsonMappingException e) {
		    e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
		
		
		
		
		
		
		
		
	}
}
