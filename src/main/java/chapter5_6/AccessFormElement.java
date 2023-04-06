package main.java.chapter5_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.VariableSettings;

public class AccessFormElement {

	public static void main(String[] args) {
		 // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
 	
        String baseUrl = "https://edev.sun-asterisk.vn/";
        String email = "nguyen.xuan.minh.nhat@framgia.com.edev.test";
        String password = "";
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
        //close Fire fox
       
        // click button login to show pop up
        WebElement btnLogin = driver.findElement(By.cssSelector("a.wsm-btn:nth-child(3)"));
        btnLogin.click();
        
        // Get element input email and password
        WebElement emailElement = driver.findElement(By.id("user_email"));
        WebElement passwordElement = driver.findElement(By.id("user_password"));
        
        // Insert value to input email and password
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
	}

}
