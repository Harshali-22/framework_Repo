package com.NinzaHRMProject.projectTest;

import org.testng.annotations.Test;

import com.NinzaHRMProject.generic.baseclassutility.BaseClass;

public class SampleTest1 extends BaseClass{

	
	@Test(groups="Regression")
	public void test1_2() {
		System.out.println("Execute test1.2");
	}
	@Test(groups="Smoke")
	public void test1_3() {
		System.out.println("Execute test1.3");
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("url"));
		System.out.println(System.getProperty("suite"));
	}
}
