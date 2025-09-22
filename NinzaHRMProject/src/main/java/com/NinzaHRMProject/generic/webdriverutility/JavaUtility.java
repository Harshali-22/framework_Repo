package com.NinzaHRMProject.generic.webdriverutility;

import java.util.Random;

public class JavaUtility {

	public int generateRandomNum() {
		Random random=new Random();
		int randomInt=random.nextInt(5000);
		return randomInt;
	}
}
