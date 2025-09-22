package com.NinzaHRMProject.generic.objectRepoutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NinzaHRMProject.generic.fileutility.FileUtility;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement userEdt;
	
	@FindBy (id="inputPassword")
	private WebElement passwordEdt;
	
	@FindBy (xpath="//button[text()='Sign in']")
	private WebElement signInBtn;
	public WebElement getUserEdt() {
		return userEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	public void login() throws IOException {
		FileUtility fLib=new FileUtility();
		String userName=fLib.getDataFromProperties("NinzaUN");
		String password=fLib.getDataFromProperties("NinzaPwd");
		userEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		signInBtn.click();
	}
}
