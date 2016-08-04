package com.zns.vehicles.service.dao.impl;

//import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
//import com.mongodb.client.MongoCollection;
import com.zns.vehicles.service.dao.SequenceDAO;

public class SequenceDAOImpl implements SequenceDAO {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	private static final String DB_NAME = "vehicleApp";
	private static final String SEQUENCE_COLLECTION = "sequence";
	public static DBCollection sequenceCollection;

	@Override
	public Object getNextSequenceId(String key) throws Exception {

		MongoClient mongoClient = new MongoClient();
		DB database = mongoClient.getDB(DB_NAME);
		
		sequenceCollection = database.getCollection(SEQUENCE_COLLECTION);

		if (sequenceCollection.count() == 0) {
			createSequenceCollection();
		}
		
		BasicDBObject searchQuery = new BasicDBObject("_id", key);
		BasicDBObject increase = new BasicDBObject("seq", 1);
		BasicDBObject updateQuery = new BasicDBObject("$inc", increase);
		DBObject result = sequenceCollection.findAndModify(searchQuery, null, null, false, updateQuery, true, false);

		return result.get("seq");
		

	}
	
	private void createSequenceCollection() {
		BasicDBObject document = new BasicDBObject();
		document.append("_id", "vehicleId");
		document.append("seq", 0);
		sequenceCollection.insert(document);
	}
}
