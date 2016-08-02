package com.zns.vehicles.service.dao.impl;

import java.util.Locale.Category;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.zns.vehicles.util.PropReader;

public class Test {

	private final static PropReader props = new PropReader();

	private final static String HOST = "mongo.host";
	private final static Integer PORT = 27017;
	private final static String DB = "mongo.db";
	private final static String USER = "mongo.collection.user";

	public static void main(String[] args) {

		String userName = "mzeeshanr45";
		System.out.println("prop:::::" + props.getProperty(USER));
		dbUtil(props.getProperty(USER), userName);
	}

	private static void dbUtil(String collection, String user) {
		MongoClient mongoClient = null;
		
		try {
			mongoClient = new MongoClient(props.getProperty(HOST), PORT);
			MongoDatabase db = mongoClient.getDatabase("vehicleApp");
			MongoCollection<Document> coll = db.getCollection("user");
			System.out.println("looking for: " + user);
			
			Document query = new Document("username", user);
			FindIterable<Document> search = coll.find(query);
		    
			if (search.iterator().hasNext()){
				System.out.println("found stuff");
			} else {
				System.out.println("found nothing");
			}

		} catch (MongoClientException e) {
			System.out.println("Error while connecting to DB...");
			e.printStackTrace();
		} catch (MongoException e) {
			System.out.println("General mongo error");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal argument exception...");
			e.printStackTrace();
		} finally {
			// System.out.println("user request has been persisted
			// sucessfully");
			mongoClient.close();
		}

	}
}
