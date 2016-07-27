package com.zns.vehicles.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filePath = "/com/zns/vehicles/config/vehicleApp.properties";
		InputStream in = null;
		Properties prop = new Properties();
		
		try {
			in = LoadProperties.class.getResourceAsStream(filePath);
			prop.load(in);
			System.out.println(prop.getProperty("mongo.db"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
