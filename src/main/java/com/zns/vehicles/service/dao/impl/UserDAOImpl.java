package com.zns.vehicles.service.dao.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import com.zns.vehicles.model.User;
import com.zns.vehicles.service.dao.UserDAO;
import com.zns.vehicles.util.PropReader;

public class UserDAOImpl implements UserDAO {

	private Logger log = LoggerFactory.getLogger(getClass());

	private final PropReader props = new PropReader();

	private final static String HOST = "mongo.host";
	private final static Integer PORT = 27017;
	private final static String DB = "mongo.db";
	private final static String USER = "mongo.collection.user";

	@Override
	public void saveUser(User userRequest) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient(props.getProperty(HOST), PORT);
			MongoDatabase db = mongoClient.getDatabase("vehicleApp");
			Document doc = new Document("username", userRequest.getUsername())
					.append("password", userRequest.getPassword()).append("FirstName", userRequest.getPersonFName())
					.append("LastName", userRequest.getPersonLName()).append("DOB", userRequest.getPersonDOB())
					.append("Zip", userRequest.getPersonZipCode()).append("email", userRequest.getPersonEmail());

			db.getCollection("user").insertOne(doc);

		} catch (MongoClientException e) {
			log.error("Error while connecting to DB...");
			e.printStackTrace();
		} catch (MongoException e) {
			log.error("General mongo error");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument exception...");
			e.printStackTrace();
		} finally {
			log.info("user request has been persisted sucessfully");
			mongoClient.close();
		}

	}
}
