package com.NinzaHRMProject.generic.webdriverutility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	public void switchToWindow(WebDriver driver,String partialText) {
		
		Set<String> handle=driver.getWindowHandles();
		for(int i=0;i<handle.size();i++) {
			
		if (handle.contains(partialText)) {
			driver.switchTo();
		}

		}
	}
	
	public void selectFromDD(WebElement Dropdown,String value) {
		
		Select sel=new Select(Dropdown);
		sel.selectByValue(value);
	}
	
	public void selectFromDD(WebElement Dropdown,int index) {
		
		Select sel=new Select(Dropdown);
		sel.selectByIndex(index);
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();;
	}
	public void rightClick(WebDriver driver,WebElement element) {
		
		Actions action=new Actions(driver);
		action.contextClick().build().perform();
	}

		
}
