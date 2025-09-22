package com.NinzaHRMProject.projectTest;

import org.testng.annotations.Test;

import com.NinzaHRMProject.generic.baseclassutility.BaseClass;

public class SampleTest3 extends BaseClass{

	@Test(groups="Smoke")
	public void test3_1() {
		System.out.println("Execute test3.1");
	}
	@Test(groups="Regression")
	public void test3_2() {
		System.out.println("Execute test3.2");
	}
	@Test(groups="Smoke")
	public void test3_3() {
		System.out.println("Execute test3.3");
	}
}
