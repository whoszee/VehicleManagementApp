package com.zns.vehicles.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {

	public String getProperty(String key) {
				
		Properties prop = new Properties();
		InputStream in = null;

		try {
			File f = new File("vehicleApp.properties");
			in = new FileInputStream(f);
		} catch (Exception e) {
			in = null;
		}

		try {
			if (in == null) {
				// Try loading from classpath
				in = PropReader.class.getResourceAsStream("vehicleApp.properties");
			}

			// Try loading properties from the file (if found)
			prop.load(in);
		} catch (Exception e) {
		}

		return prop.getProperty(key);
	}
}
