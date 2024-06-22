package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertyUtility {

	private FileInputStream fis;
	private Properties prop;
	
	public void getProperty(String data)
	{
		try {
			fis = new FileInputStream(IpathConstants.propertyFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		prop.getProperty(data);
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
