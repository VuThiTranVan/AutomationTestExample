package chapter12;

import java.awt.AWTException;
//The package references to the Robot class in java which is required simulate keyboard and mouse events.
import java.awt.Robot;
// The package allows the user to use keyPress and keyRelease events of a keyboard.
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.VariableSettings;

//3. Handling popup of window
public class PopupOfindow {
	public final static String EMAIL = ""; // your email to test
	public final static String EMAIL_PASSWORD = ""; // your email p to test
	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);
			WebDriver driver = new FirefoxDriver();

			WebDriverWait wait;

			driver.get("https://gmail.com");
			driver.manage().window().maximize();
			// *[@id="identifierId"]
			// enter a valid email address
			driver.findElement(By.id("identifierId")).sendKeys(EMAIL);
			driver.findElement(By.id("identifierNext")).click();

			wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
			// enter a valid password
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(EMAIL_PASSWORD);

			// click on sign in button
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='passwordNext']")));
			driver.findElement(By.xpath("//*[@id='passwordNext']")).click();
			Thread.sleep(30000);

			// click on compose button
			wait = new WebDriverWait(driver, 2);
			// wait.until(ExpectedConditions
			// .presenceOfElementLocated(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")));
			// driver.findElement(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".T-I-KE")));
			driver.findElement(By.cssSelector(".T-I-KE")).click();
			// click on attach files icon
			driver.findElement(By.xpath("//div[contains(@command,'Files')]//div[contains(@class,'aaA')]")).click();

			// download file with name [Selenium]
			// creating instance of Robot class (A java based utility)
			Robot rb = new Robot();

			// pressing keys with the help of keyPress and keyRelease events
			rb.keyPress(KeyEvent.VK_SHIFT);
			rb.keyPress(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_SHIFT);
			Thread.sleep(2000);

			rb.keyPress(KeyEvent.VK_E);
			rb.keyRelease(KeyEvent.VK_E);

			rb.keyPress(KeyEvent.VK_L);
			rb.keyRelease(KeyEvent.VK_L);
			Thread.sleep(2000);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
