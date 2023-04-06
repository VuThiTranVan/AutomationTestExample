package main.java.chapter17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.VariableSettings;

public class JavaScriptExecureEx2 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();

		driver.get("https://shop.demoqa.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.linkText("My Account"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(1000);

        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);

        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: " + domainName);

        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");

        Thread.sleep(2000);

	}

}
