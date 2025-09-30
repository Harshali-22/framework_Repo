package com.NinzaHRMProject.projectTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.NinzaHRMProject.generic.baseclassutility.BaseClass;
import com.NinzaHRMProject.generic.fileutility.ExcelUtility;

public class SampleTest1 extends BaseClass{

	@Test(enabled = false)
	public void test1_3() {
		System.out.println("Execute test1.3");
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("url"));
		System.out.println(System.getProperty("suite"));
		System.out.println("Hello");
	}
	
	@Test(groups="Regression")
	public void test1_2() throws EncryptedDocumentException, IOException {
		System.out.println("Execute test1.2");
		ExcelUtility eLib=new ExcelUtility();
		System.out.println(eLib.getDataFromExcel("prod", 1, 1));
		eLib.setDataIntoExcel("prod", 6, 1, "SetValue-Working");
	
	}

}
