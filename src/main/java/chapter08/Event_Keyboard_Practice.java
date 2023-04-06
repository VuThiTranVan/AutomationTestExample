package main.java.chapter08;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.VariableSettings;

public class Event_Keyboard_Practice {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();
//		exmple_Action_class(driver);
//		exmple_Action_class_other(driver);

//		// dùng để dừng màn hình thôi mà
//		Thread.sleep(7200);
		example_Sendkeys_chord(driver);
//		Thread.sleep(7200);
//		example_Robot_class(driver);
//		Thread.sleep(7200);
		
		//____________*example for handle mouse events*___________
//		practice_handle_keyboard_event(driver);
//		Thread.sleep(7200);
//		example_double_click(driver);
//		Thread.sleep(7200);
//		example_right_click(driver);
//		Thread.sleep(7200);
//		exampl_multi_actions(driver);
		
		driver.close();
	}

	// ví dụ của 1. Using Action class
	public static void exmple_Action_class(WebDriver driver) {
		driver.get("https://wsm.framgia.vn/");

		// Create object of Action class
		Actions action = new Actions(driver);
		// Sendkeys using Action class object
		action.sendKeys(Keys.ENTER).build().perform();
		// Send mulyiple keys using action class
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	}

	// ví dụ 2 của Using Action class
	public static void exmple_Action_class_other(WebDriver driver) {
		driver.get("https://www.google.com/");

		WebElement input_search = driver.findElement(By.cssSelector(".gLFyf"));
		Actions action = new Actions(driver);
		// action.sendKeys(Keys.ENTER).build().perform();
		// Keys.RETURN instead of Keys.ENTER

		// ways other
		action.sendKeys(input_search, "facebook").sendKeys(input_search, Keys.ENTER).build().perform();

	}

	// 1. Using sendkeys chord
	public static void example_Sendkeys_chord(WebDriver driver) throws InterruptedException {
		driver.get("https://www.google.com/");

		WebElement input_search = driver.findElement(By.cssSelector(".gLFyf"));
		input_search.sendKeys("WebDriver");
		// input_search.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME),
		// Keys.DELETE);
		Thread.sleep(3600);
		input_search.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
	}

	// 1. Using Robot class
	public static void example_Robot_class(WebDriver driver) throws AWTException, InterruptedException {
		driver.get("https://wsm.framgia.vn/en/all-tools");

		// Create Robot class
		Robot rb = new Robot();
		// Press control keyboard key
		rb.keyPress(KeyEvent.VK_CONTROL);

		// Press A keyboard key
		rb.keyPress(KeyEvent.VK_A);
		Thread.sleep(3600);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		driver.close();
	}

	// Practice 1. Handling keyboard events
	// 1. Handling keyboard events
	public static void practice_handle_keyboard_event(WebDriver driver) {
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		WebElement input_search = driver.findElement(By.cssSelector(".gLFyf"));

		// Creating object of Actions class
		Actions builder = new Actions(driver);

		builder.sendKeys(input_search, "WebDriver").sendKeys(input_search, Keys.BACK_SPACE).sendKeys("selenium")
				.sendKeys(Keys.SPACE).sendKeys("WebDriver").build().perform();
	}

	// ví dụ thêm thôi, ko có nội dung trong slide
	public static void other(WebDriver driver) {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement text = driver.findElement(By.name("q"));

		Actions make = new Actions(driver);

		Action kbEvents = make.keyDown(text, Keys.SHIFT).sendKeys("Java Code Geeks").keyUp(text, Keys.SHIFT)
				.doubleClick().contextClick().build();
		kbEvents.perform();
	}

	// ___________________***______________________
	// Example của 2. Handling mouse events
	/**
	 * Event mouse 2. Handling mouse events
	 */
	public static void example_1_Hanling_mouse_event(WebDriver driver) throws InterruptedException {
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		driver.get(baseUrl);

		WebElement link_Home = driver.findElement(By.linkText("Home"));
		WebElement td_Home = driver.findElement(
				By.xpath("/html/body/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr"));
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(link_Home).build();
		System.out.println("Before hover: " + td_Home.getCssValue("background-color"));

		mouseOverHome.perform();
		System.out.println("After hover: " + td_Home.getCssValue("background-color"));
		driver.close();
	}

	// Example 2: Double click
	public static void example_double_click(WebDriver driver) {

		String base_url = new File("resources/chapter08/double_click.html").getAbsolutePath().toString();
		driver.get(VariableSettings.ROOT_LINK + base_url);

		// Create object of Action class
		Actions action = new Actions(driver);

		// Find element using locator and store into WebElement
		WebElement element = driver.findElement(By.id("btn_click"));

		// Perform Double click operation using action (object) on element.
		action.doubleClick(element).perform();
	}

	// 2. Handling mouse events - right click
	public static void example_right_click(WebDriver driver) {
		driver.get("https://www.google.com/");

		// Create object of Action class
		Actions action = new Actions(driver);

		// Perform Double click operation using action (object) on element.
		action.contextClick().perform();
	}

	// 3. Multiple Actions
	public static void exampl_multi_actions(WebDriver driver) {
		driver.get("http://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement text = driver.findElement(By.name("q"));

		Actions make = new Actions(driver);

		Action kbEvents = make.keyDown(text, Keys.SHIFT).sendKeys("Selenium WebDriver").keyUp(text, Keys.SHIFT)
				.doubleClick().contextClick().build();
		kbEvents.perform();
	}
}
