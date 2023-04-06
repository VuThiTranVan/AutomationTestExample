package main.java.chapter17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.VariableSettings;

public class ExecuteAsynScriptEx2 {
	/*
	 * Ứng dụng chờ 5 giây để thực hiện thêm một hành động.
	 * result: Hiển thị thành công thời gian đã qua hơn 5 giây (5000 mili giây)
	 */
	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();

		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Launching the Site.
		driver.get("https://demo.guru99.com/V4/");

		// Maximize window
		driver.manage().window().maximize();

		// Set the Script Timeout to 20 seconds
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

		// Declare and set the start time
		long start_time = System.currentTimeMillis();

		// Call executeAsyncScript() method to wait for 5 seconds
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

		// Get the difference (currentTime - startTime) of times.
		System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));

	}

}
