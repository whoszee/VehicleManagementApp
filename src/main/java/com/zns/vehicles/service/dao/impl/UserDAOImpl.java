package com.zns.vehicles.service.dao.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.zns.vehicles.model.CreateUserRequest;
import com.zns.vehicles.service.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	private Logger log = LoggerFactory.getLogger(getClass());

	private final Properties prop = new Properties();

	@Override
	public void saveUser(CreateUserRequest userRequest) {
		// TODO Auto-generated method stub
		log.info("inside dao");
		InputStream in = null;
		try{
		in = this.getClass().getClassLoader().getResourceAsStream("/com/zns/vehicles/config/vehicleApp.properties");
		} catch (Exception e){
			log.error(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			e.printStackTrace();
			log.error("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		//("com/zns/vehicles/config/vehicleApp.properties");

		try {

			prop.load(in);

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + prop.getProperty("mongo.db"));

			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB db = mongoClient.getDB(prop.getProperty("mongo.db"));
			DBCollection coll = db.getCollection(prop.getProperty("mongo.collection.user"));

			BasicDBObject doc = new BasicDBObject("username", userRequest.getUsername())
					.append("password", userRequest.getPassword()).append("FirstName", userRequest.getPersonFName())
					.append("LastName", userRequest.getPersonLName()).append("DOB", userRequest.getPersonDOB())
					.append("Zip", userRequest.getPersonZipCode()).append("email", userRequest.getPersonEmail());
			coll.insert(doc);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
