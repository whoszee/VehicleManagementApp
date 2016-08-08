package com.zns.vehicles.util;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.zns.vehicles.model.RetrievalRequest;

public class Test {

	private final static String HOST = "localhost";
	private final static Integer PORT = 27017;

	public static void main(String[] args) {

		RetrievalRequest request = new RetrievalRequest();
		request.setUserName("mzeeshan49");
		request.setVehicleType("car");
		
		System.out.println(dbGetUtil(request));
				
	}

	private static ArrayList<String> dbGetUtil(RetrievalRequest requestPartial) {

		MongoClient mongoClient = null;
		ArrayList<String> results = new ArrayList<String>();

		PropReader props = null;

		try {
			mongoClient = new MongoClient(HOST, PORT);
			MongoDatabase db = mongoClient.getDatabase("vehicleApp");

			System.out.println("querying this collection >>>>>>>>>>>>>>>>>>>>>>>>>> " + db.getCollection("vehicles"));

			FindIterable<Document> iterable = db.getCollection("vehicles")
					.find(new Document("username", requestPartial.getUserName()).append("vehicleType",
							requestPartial.getVehicleType()));

			iterable.forEach(new Block<Document>() {
				@Override
				public void apply(final Document document) {
					System.out.println("result>>>>>>>>>>>>>> " + document.toString());
					results.add(document.toString());
				}
			});

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
			// log.info("submitted request has been persisted successfully");
			//mongoClient.close();
		}
		System.out.println("arraylist contents for search::::::::: " + results.size());
		return results;
	}
}