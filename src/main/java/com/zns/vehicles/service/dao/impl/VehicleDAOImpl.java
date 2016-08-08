package com.zns.vehicles.service.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.zns.vehicles.model.Car;
import com.zns.vehicles.model.Motorcycle;
import com.zns.vehicles.model.RetrievalRequest;
import com.zns.vehicles.model.RetrievalResponse;
import com.zns.vehicles.model.Truck;
import com.zns.vehicles.service.dao.VehicleDAO;
import com.zns.vehicles.util.PropReader;
import com.zns.vehicles.util.RequestDeserializer;

public class VehicleDAOImpl implements VehicleDAO {

	private Logger log = LoggerFactory.getLogger(getClass());

	private final PropReader props = new PropReader();
	private final RequestDeserializer deserializer = new RequestDeserializer();

	private final static String HOST = "mongo.host";
	private final static Integer PORT = 27017;
	private final static String DB = "mongo.db";
	private final static String USER = "mongo.collection.user";
	private final static String VEHICLES = "mongo.collection.vehicle";
	private final static String[] ALL = { "car", "truck", "motorcycle" };
	private final static String CAR = "car";
	private final static String TRUCK = "truck";
	private final static String MOTORCYCLE = "motorcycle";

	@Override
	public void saveVehicle(Car request) {
		// TODO Auto-generated method stub
		log.info("Persisting your car entry");

		log.info("Registering car with ID: " + request.get_id().toString());

		Document doc = new Document("username", request.getUsername()).append("make", request.getMake())
				.append("model", request.getModel()).append("year", request.getYear())
				.append("exteriorColor", request.getExteriorColor()).append("interiorColor", request.getInteriorColor())
				.append("doors", request.getDoors()).append("mileage", request.getMileage())
				.append("drivetrain", request.getDrivetrain()).append("licenseClass", request.getLicenseClass())
				.append("transmission", request.getTransmission()).append("cylinderCount", request.getCylinderCount())
				.append("fuelType", request.getFuelType()).append("_id", request.get_id())
				.append("vehicleType", request.getVehicleType());

		dbPostUtil("vehicles", doc);
	}

	@Override
	public void saveVehicle(Motorcycle request) {
		// TODO Auto-generated method stub
		log.info("Persisting your motorcycle entry");

		log.info("Registering moto with ID: " + request.get_id().toString());

		Document doc = new Document("username", request.getUsername()).append("make", request.getMake())
				.append("model", request.getModel()).append("year", request.getYear())
				.append("color", request.getColor()).append("licenseClass", request.getLicenseClass())
				.append("transmission", request.getTransmission()).append("fuelType", request.getFuelType())
				.append("mileage", request.getMileage()).append("_id", request.get_id())
				.append("vehicleType", request.getVehicleType());

		dbPostUtil("vehicles", doc);
	}

	@Override
	public void saveVehicle(Truck request) {
		// TODO Auto-generated method stub
		log.info("Persisting your truck entry");

		log.info("Registering truck with ID: " + request.get_id().toString());

		Document doc = new Document("username", request.getUsername()).append("make", request.getMake())
				.append("model", request.getModel()).append("year", request.getYear())
				.append("exteriorColor", request.getExteriorColor()).append("interiorColor", request.getInteriorColor())
				.append("doors", request.getDoors()).append("mileage", request.getMileage())
				.append("drivetrain", request.getDrivetrain()).append("licenseClass", request.getLicenseClass())
				.append("transmission", request.getTransmission()).append("cylinderCount", request.getCylinderCount())
				.append("fuelType", request.getFuelType())
				.append("vehicleClassification", request.getVehicleClassification()).append("_id", request.get_id())
				.append("vehicleType", request.getVehicleType());

		dbPostUtil("vehicles", doc);
	}

	private void dbPostUtil(String collection, Document doc) {
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

	private ArrayList<String> dbGetUtil(RetrievalRequest requestPartial) {

		MongoClient mongoClient = null;
		ArrayList<String> results = new ArrayList<String>();

		try {
			mongoClient = new MongoClient(props.getProperty(HOST), PORT);
			MongoDatabase db = mongoClient.getDatabase("vehicleApp");

			log.info("querying this collection >>>>>>>>>>>>>>>>>>>>>>>>>> " + db.getCollection("vehicles").toString());
			log.info("looking for vehicle type:::::::: " + requestPartial.getVehicleType());

			FindIterable<Document> iterable = db.getCollection("vehicles")
					.find(new Document("username", requestPartial.getUserName()).append("vehicleType",
							requestPartial.getVehicleType()));

			iterable.forEach(new Block<Document>() {
				@Override
				public void apply(final Document document) {
					log.info("result>>>>>>>>>>>>>> " + document.toString());
					results.add(document.toJson());
				}
			});

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
			mongoClient.close();
		}
		log.info("arraylist contents for search::::::::: " + results.size());
		return results;
	}

	@Override
	public RetrievalResponse retrieveVehiclesForUser(RetrievalRequest request) {

		RetrievalResponse finalResponse = new RetrievalResponse();
		String retrievalType = request.getVehicleType();

		log.info("retrieval type is:::::::::::::: " + retrievalType);

		if (retrievalType.equals("all")) {
			log.info("all vehicles requested");

			request.setVehicleType(CAR);
			finalResponse.setCar(carUtil(request));

			request.setVehicleType(MOTORCYCLE);
			finalResponse.setMoto(motoUtil(request));

			request.setVehicleType(TRUCK);
			finalResponse.setTruck(truckUtil(request));

			return finalResponse;

		} else if (retrievalType.equals(CAR)) {

			finalResponse.setCar(carUtil(request));
			log.info("FINAL RESPONSE CAR >>>>>>>>>>>>>>");
			log.info(finalResponse.toString());
			return finalResponse;

		} else if (retrievalType.equals(MOTORCYCLE)) {

			finalResponse.setMoto(motoUtil(request));
			log.info("FINAL RESPONSE HAHAHAH>>>>>>>>>>>>>>");
			log.info(finalResponse.toString());

			return finalResponse;

		} else if (retrievalType.equals(TRUCK)) {

			finalResponse.setTruck(truckUtil(request));
			log.info("FINAL RESPONSE HAHAHAH>>>>>>>>>>>>>>");
			log.info(finalResponse.toString());

			return finalResponse;

		} else {
			log.error("INVALID CAR TYPE.....");
		}

		return null;
	}

	public ArrayList<Car> carUtil(RetrievalRequest request) {
		log.info("all cars requested");

		List<String> carsList = dbGetUtil(request);
		ArrayList<Car> listOfCars = new ArrayList<Car>();

		log.info("LENGTH OF CARSLIST:::::: " + carsList.size());

		for (String singleCar : carsList) {
			listOfCars.add(deserializer.convertCarRequest(singleCar));
		}

		log.info("SIZE OF LIST<CAR>>>>>>>>>>. " + listOfCars.size());
		return listOfCars;
	}

	public ArrayList<Motorcycle> motoUtil(RetrievalRequest request) {
		log.info("all motos requested");

		List<String> motoList = dbGetUtil(request);
		ArrayList<Motorcycle> listOfMotos = new ArrayList<Motorcycle>();

		log.info("LENGTH OF MOTOSLIST:::::: " + motoList.size());

		for (String singleMoto : motoList) {
			listOfMotos.add(deserializer.convertMotoRequest(singleMoto));
		}

		log.info("SIZE OF LIST<MOTORCYCLE>>>>>>>>>>. " + listOfMotos.size());
		return listOfMotos;
	}

	public ArrayList<Truck> truckUtil(RetrievalRequest request) {
		log.info("all truckss requested");

		List<String> trucksList = dbGetUtil(request);
		ArrayList<Truck> listOfTrucks = new ArrayList<Truck>();

		log.info("LENGTH OF TRUCKSLIST:::::: " + trucksList.size());

		for (String singleTruck : trucksList) {
			listOfTrucks.add(deserializer.convertTruckRequest(singleTruck));
		}

		log.info("SIZE OF LIST<TRUCK>>>>>>>>>>. " + listOfTrucks.size());
		return listOfTrucks;
	}
}
