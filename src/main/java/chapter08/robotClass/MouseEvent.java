package main.java.chapter08.robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.VariableSettings;

public class MouseEvent {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// Example 1
//		driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); // sample url
//		Robot robot = new Robot();
//		robot.mouseMove(630, 420); // move mouse point to specific location
//		robot.delay(1500); // delay is to make code wait for mentioned milliseconds before executing next
//							// step
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click
//		robot.delay(1500);
//		robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button
//		Thread.sleep(1000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		// press enter key of keyboard to perform above selected action
//		// Close the main window
//		driver.close();

		// Example 2
		driver.get("https://www.edureka.co/");
		driver.findElement(By.linkText("Courses")).click();
		Robot robot = new Robot();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("a");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("b");
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		System.out.println("c");
		robot.mouseMove(30, 100);
		Thread.sleep(4000);
		System.out.println("d");
		driver.quit();

	}
}
