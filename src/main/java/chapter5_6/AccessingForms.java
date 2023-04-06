package main.java.chapter5_6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.VariableSettings;

public class AccessingForms {
	public static void main(String[] args) throws InterruptedException {
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
        
        // Click choose Remember me
        WebElement rememberElement = driver.findElement(By.className("span-remember"));
        WebElement rememberRealElement = driver.findElement(By.id("user_remember_me"));
        rememberElement.click();       
        if(rememberRealElement.isSelected()) {
        	System.out.println("Login with rememberme");
        } else {
        	System.out.println("Login without rememberme");
        }
        
        //clear() method
        //emailElement.clear();
        //passwordElement.clear();
        WebElement btnSubmitLogin = driver.findElement(By.className("login-success"));
        btnSubmitLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-nav li:nth-child(6)")));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        WebElement manageUsersElement = driver.findElement(By.cssSelector(".sidebar-nav li:nth-child(6)"));
        actions.moveToElement(manageUsersElement).perform();
        manageUsersElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sidebar-nav li:nth-child(6) li:first-child")));
        WebElement usersElement = driver.findElement(By.cssSelector(".sidebar-nav li:nth-child(6) li:first-child"));
        usersElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[2]")));
        WebElement editUserElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[11]/div/a[2]"));
        editUserElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user_general_info_attributes_gender_male\"]")));
        WebElement genderUserElement = driver.findElement(By.xpath("//*[@id=\"user_general_info_attributes_gender_male\"]"));
        genderUserElement.click();
        
        
        // Chapter 6 - DropDown select
        WebElement staffTypeUserElement = driver.findElement(By.xpath("//*[@id=\"user_staff_type_id\"]"));
        Select staffTypeUserSelect= new Select(staffTypeUserElement);
        //staffTypeUserSelect.selectByVisibleText("Part-time");
        staffTypeUserSelect.selectByIndex(2);
	}
}
