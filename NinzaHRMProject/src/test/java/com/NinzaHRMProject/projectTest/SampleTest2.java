package com.NinzaHRMProject.projectTest;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.NinzaHRMProject.generic.baseclassutility.BaseClass;

@Listeners(com.NinzaHRMProject.generic.listenerutility.ListenerImplementation.class)
public class SampleTest2 extends BaseClass  {

	@Test(groups="Regression")
	public void test2_1() {
		System.out.println("Execute test2.1");
	}
	@Test(groups="Smoke")
	public void test2_2() {
		System.out.println("Execute test2.2");
	}
	@Test(groups="Regression")
	public void test2_3() {
		System.out.println("Execute test2.3");
	}
}
