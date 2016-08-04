package com.zns.vehicles.service.dao;

import com.zns.vehicles.exception.SequenceException;

public interface SequenceDAO {
	
	Object getNextSequenceId(String key) throws Exception;

}
