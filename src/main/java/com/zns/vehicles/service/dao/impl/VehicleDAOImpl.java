package com.zns.vehicles.service.dao.impl;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.client.MongoDatabase;
import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.service.dao.SequenceDAO;
import com.zns.vehicles.service.dao.VehicleDAO;
import com.zns.vehicles.util.PropReader;

public class VehicleDAOImpl implements VehicleDAO {

	private Logger log = LoggerFactory.getLogger(getClass());

	private final PropReader props = new PropReader();

	private SequenceDAO sequenceDao = new SequenceDAOImpl();

	private final static String HOST = "mongo.host";
	private final static Integer PORT = 27017;
	private final static String DB = "mongo.db";
	private final static String USER = "mongo.collection.user";
	private final static String CAR = "car";
	private final static String TRUCK = "truck";
	private final static String MOTO = "motorcycle";

	@Override
	public void saveVehicle(Car request) {
		// TODO Auto-generated method stub
		log.info("Persisting your car entry");

		try {
			request.setVehicleId(vehicleIdValidator(sequenceDao.getNextSequenceId("vehicleId").toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error getting next sequence id for this vehicle");
			e.printStackTrace();
		}

		request.setVehicleType(CAR);

		log.info("Registering car with ID: " + request.getVehicleId().toString());

		Document doc = new Document("username", request.getUserName()).append("make", request.getMake())
				.append("model", request.getModel()).append("year", request.getYear())
				.append("exteriorColor", request.getExteriorColor()).append("interiorColor", request.getInteriorColor())
				.append("doors", request.getDoors()).append("mileage", request.getMileage())
				.append("driveTrain", request.getDrivetrain()).append("licenseClass", request.getLicenseClass())
				.append("transmission", request.getTransmission()).append("cylinderCount", request.getCylinderCount())
				.append("fuelType", request.getFuelType()).append("vehicleId", request.getVehicleId())
				.append("vehicleType", request.getVehicleType());

		dbUtil("vehicles", doc);
	}

	@Override
	public void saveVehicle(Motorcycle request) {
		// TODO Auto-generated method stub
		log.info("Persisting your motorcycle entry");

		try {
			request.setVehicleId(vehicleIdValidator(sequenceDao.getNextSequenceId("vehicleId").toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setVehicleType(MOTO);

		log.info("Registering moto with ID: " + request.getVehicleId().toString());

		Document doc = new Document("username", request.getUserName()).append("make", request.getMake())
				.append("model", request.getModel()).append("year", request.getYear())
				.append("color", request.getColor()).append("licenseClass", request.getLicenseClass())
				.append("transmission", request.getTransmission()).append("fuelType", request.getFuelType())
				.append("mileage", request.getMileage()).append("vehicleId", request.getVehicleId())
				.append("vehicleType", request.getVehicleType());

		dbUtil("vehicles", doc);
	}

	@Override
	public void saveVehicle(Truck request) {
		// TODO Auto-generated method stub
		log.info("Persisting your truck entry");

		try {
			request.setVehicleId(vehicleIdValidator(sequenceDao.getNextSequenceId("vehicleId").toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setVehicleType(TRUCK);

		log.info("Registering truck with ID: " + request.getVehicleId().toString());

		Document doc = new Document("username", request.getUserName()).append("make", request.getMake())
				.append("model", request.getModel()).append("year", request.getYear())
				.append("exteriorColor", request.getExteriorColor()).append("interiorColor", request.getInteriorColor())
				.append("doors", request.getDoors()).append("mileage", request.getMileage())
				.append("driveTrain", request.getDrivetrain()).append("licenseClass", request.getLicenseClass())
				.append("transmission", request.getTransmission()).append("cylinderCount", request.getCylinderCount())
				.append("fuelType", request.getFuelType()).append("VehicleClass", request.getVehicleClassification())
				.append("vehicleId", request.getVehicleId()).append("vehicleType", request.getVehicleType());

		dbUtil("vehicles", doc);
	}

	private void dbUtil(String collection, Document doc) {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient(props.getProperty(HOST), PORT);
			MongoDatabase db = mongoClient.getDatabase("vehicleApp");

			db.getCollection(collection).insertOne(doc);

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
			log.info("submitted request has been persisted sucessfully");
			mongoClient.close();
		}
	}

	private String vehicleIdValidator(String currentVehicleId) {
		String newVehicleId = null;
		if (currentVehicleId.endsWith(".0")) {
			newVehicleId = (currentVehicleId.substring(0, currentVehicleId.length() - 2));
		}
		return newVehicleId;
	}
}
