package com.NinzaHRMProject.generic.baseclassutility;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;

import com.NinzaHRMProject.generic.databaseutility.DataBaseUtility;
import com.NinzaHRMProject.generic.fileutility.FileUtility;
import com.NinzaHRMProject.generic.objectRepoutility.HomePage;
import com.NinzaHRMProject.generic.objectRepoutility.LoginPage;
import com.NinzaHRMProject.generic.webdriverutility.UtilityClassObject;
@Parameters("browser")
public class BaseClass {
	
	DataBaseUtility dbLib=new DataBaseUtility();
	FileUtility fLib=new FileUtility();
	WebDriver driver;
	
	@BeforeSuite(groups= {"Smoke","Regression"})
	public void configBS() throws IOException, SQLException {
		System.out.println("===@BeforeSuite Execution Started===");
		dbLib.getDBConnection();
	}
	@BeforeClass (groups= {"Smoke","Regression"})
	public void configBC(XmlTest xtest) throws IOException {
		System.out.println("===@BeforeClass Execution Started===");
		
		String browser=System.getProperty("browser");
		System.out.println("command line browser = "+browser);

		if (browser==null) {
			browser=xtest.getParameter("Browser");
			System.out.println("Xml file browser = "+browser);
			if (browser==null) {				
				browser=fLib.getDataFromProperties("Browser");
				System.out.println("properties file browser = "+browser);
			}
		}
		
				System.getProperty("browser", fLib.getDataFromProperties("Browser"));
		String url=fLib.getDataFromProperties("NinzaUrl");
		
		
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			final Map<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("credentials_enable_service", false);
			chromePrefs.put("profile.password_manager_enabled", false);
			chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

			final ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver=new ChromeDriver(chromeOptions);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("e"
				+ "dge")) {
			driver=new EdgeDriver();
		}
		else {driver=new ChromeDriver();}
		
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}
	@BeforeMethod(groups= {"Smoke","Regression"})
	public void configBM() throws IOException {
		System.out.println("===@BeforeMethod Execution Started===");
		
		LoginPage lpObj=new LoginPage(driver);
		lpObj.login();
	}
	@AfterMethod(groups= {"Smoke","Regression"})
	public void configAM() {
		System.out.println("===@AfterMethod Execution Started===");
		
		HomePage hpObj=new HomePage(driver);
		hpObj.logout();
	}
	@AfterClass(groups= {"Smoke","Regression"})
	public void configAC() {
		System.out.println("===@AfterClass Execution Started===");
		
		driver.quit();
	}
	@AfterSuite(groups= {"Smoke","Regression"})
	public void cofigAS() {
		System.out.println("===@AfterSuite Execution Started===");
		
		dbLib.closeConnection();
	}
	
}
