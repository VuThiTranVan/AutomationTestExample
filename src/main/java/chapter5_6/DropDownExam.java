package main.java.chapter5_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import util.VariableSettings;

import org.openqa.selenium.By;

public class DropDownExam {
	public static void main(String[] args) throws InterruptedException {
		// Init Driver
		System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();
		
		// Set and go to base URL
//		String baseURL = "http://demo.guru99.com/test/newtours/register.php";
//		driver.get(baseURL);
//
//		// Find select element and Select value
//		Select drpCountry = new Select(driver.findElement(By.name("country")));
//		drpCountry.selectByVisibleText("VIETNAM");

		//Selecting Items in a Multiple SELECT elements
		driver.get("http://jsbin.com/osebed/2");
		Thread.sleep(300);
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		if(fruits.isMultiple()) {
			System.out.println("Select support multiple !!!!");
			fruits.selectByVisibleText("Banana");

			Thread.sleep(300);
			fruits.selectByIndex(1);

			Thread.sleep(300);
		} else {
			System.out.println("Select don't support multiple !!!!");
		}
		
	}
}
