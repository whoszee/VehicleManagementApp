package com.zns.vehicles.util;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Test {

	private final static String HOST = "mongo.host";
	private final static String PORT = "mongo.port";
	private final static String DB = "mongo.db";
	private final static String USER = "mongo.collection.user";

	public static void main(String[] args) {
		PropReader props = new PropReader();

		MongoClient mongoClient = new MongoClient(props.getProperty(HOST), 27017);
		MongoDatabase db = mongoClient.getDatabase(props.getProperty(DB));
System.out.println(props.getProperty(DB));
		db.getCollection(props.getProperty(USER)).insertOne(new Document("username", "username")
				.append("password", "username").append("FirstName", "username")
				.append("LastName", "username")
				.append("DOB", "username").append("Zip", "username")
				.append("email", "username"));
		
		//System.out.println(Integer.valueOf(props.getProperty(PORT)));
		System.out.println("completed .........................");
	}
}
