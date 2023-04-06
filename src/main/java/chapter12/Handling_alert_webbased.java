package main.java.chapter12;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.VariableSettings;

public class Handling_alert_webbased {

	/**
	 * 
	 * if has errors because not found element You should add 2 line code below
	 * WebDriverWait wait = new WebDriverWait(driver, 2);
	 * wait.until(ExpectedConditions.alertIsPresent());
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", VariableSettings.PATH_CHROME);
		WebDriver driver = new ChromeDriver();
		
//		example_simple_alert(driver);
//		Thread.sleep(3600);
////
//		example_confirmation_alert(driver);
//		Thread.sleep(3600);
//
//		example_prompt_alert(driver);
//		Thread.sleep(3600);

		example_handle_multi_windows(driver);
	}

	// 2. Handling alert of web-based popup
	// Example: Simple alert
	public static void example_simple_alert(WebDriver driver) throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		// This step will result in an alert on screen
		// This step produce an alert on screen
		driver.findElement(By.id("alertButton")).click();

		// Switch the control of 'driver' to the Alert from main Window
		Alert simpleAlert = driver.switchTo().alert();

		// getText() used to get the text from the Alert
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);
		Thread.sleep(3600);
		// .accept() is used to accept the alert '(click on the Ok button)'
		simpleAlert.accept();
	}

	public static void example_confirmation_alert(WebDriver driver) throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		// This step will result in an alert on screen
//		WebElement element = driver.findElement(By.id("confirmButton"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		driver.findElement(By.id("confirmButton")).click();

		Alert confirmationAlert = driver.switchTo().alert();

		Thread.sleep(2000);
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);
		confirmationAlert.dismiss();
	}

	public static void example_prompt_alert(WebDriver driver) throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();

		// This step will result in an alert on screen
		WebElement element = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		System.out.println("Alert text is " + alertText);

		// Send some text to the alert
		promptAlert.sendKeys("Accepting the alert");

		Thread.sleep(1000);
		promptAlert.accept();

	}

	public static void example_handle_multi_windows(WebDriver driver) throws Exception {
		// Handling multiple windows in selenium webdriver using above scenario.
		// Launching the site.
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();

//		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

		driver.findElement(By.linkText("Click Here")).click();
		String MainWindow = driver.getWindowHandle();
		
		Thread.sleep(3000);
		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);

				WebDriverWait wait = new WebDriverWait(driver, 200);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name("emailid")));
				driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");

				driver.findElement(By.name("btnLogin")).click();

				// Closing the Child Window.
//				driver.close();
			}
		}
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);
	}
}