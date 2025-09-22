package com.NinzaHRMProject.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./ConfigData/CommonData.Properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(key);
		return value;
	}	

}
