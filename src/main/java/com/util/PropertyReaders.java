package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaders 
{
	static Properties prop = null;
	static FileInputStream fis = null;
	static String readProperty(String propName)
	{
		String val = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "configdata.properties");
			prop = new Properties();
			prop.load(fis);
			val = prop.getProperty(propName);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return val;
	}
	}

