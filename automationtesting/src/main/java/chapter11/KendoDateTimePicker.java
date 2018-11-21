package chapter11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.VariableSettings;

public class KendoDateTimePicker {

	private String demosite = "http://demos.telerik.com/kendo-ui/datetimepicker/index";

	WebDriver driver;
	WebDriverWait wait;

	public void startTest() {
		System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);
		// Launch the demo site to handle date time picker.
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
	}

	// example 1 - slide 6
	public void SelectDateFromKendoCalendar() throws InterruptedException {

		// Start the date time picker demo website.
		driver.navigate().to(demosite);

		// click to open the date time picker calendar.
		WebElement kendodtp = driver.findElement(By.cssSelector(".k-icon.k-i-calendar"));
		kendodtp.click();

		// change month middle
		// HandleKendoDateTimePicker_change_month("Jan");

		// Using button next
		HandleKendoDateTimePicker_change_month_with_next();

		// Provide the day of the month to select the date.
		HandleKendoDateTimePicker_for_day("11");

		HandleKendoDateTimePicker_for_time("5:00 AM");
	}

	// example 2 - slide 7
	// Function to select the day of the month in the date time picker.
	public void HandleKendoDateTimePicker_for_day(String day) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("k-content")));
		WebElement table = driver.findElement(By.className("k-content"));

		List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.xpath("td"));

			for (WebElement cell : cells) {
				if (cell.getText().equals(day)) {
					driver.findElement(By.linkText(day)).click();
				}
			}
		}

		// Intentional pause for 2 seconds.
		Thread.sleep(2000);
	}

	// Function to select the TIME
	public void HandleKendoDateTimePicker_for_time(String time) throws InterruptedException {
		/// FOR TIME
		WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));

		// click time picker button
		selectTime.click();

		// get list of times
		List<WebElement> allTime = driver.findElements(
				By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));

		// select correct time

		for (WebElement webElement : allTime) {

			if (webElement.getText().equalsIgnoreCase(time)) {

				webElement.click();

			}
		}
		// Intentional pause for 2 seconds.
		Thread.sleep(2000);
	}

	// Function to select the day of the month in the date time picker.
	public void HandleKendoDateTimePicker_change_month(String month) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("k-nav-fast")));

		// click buton
		WebElement midle_link = driver.findElement(By.cssSelector(".k-nav-fast"));

		midle_link.click();

		List<WebElement> tableRows = driver
				.findElements(By.xpath("//table[@class='k-content k-meta-view k-year']/tbody/tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.xpath("td"));

			for (WebElement cell : cells) {
				if (cell.getText().equals(month)) {
					driver.findElement(By.linkText(month)).click();
				}
			}
		}

		// Intentional pause for 2 seconds.
		Thread.sleep(2000);
	}

	// Function to select the day of the month in the date time picker.
	public void HandleKendoDateTimePicker_change_month_with_next() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("k-nav-next")));

		// click buton
		WebElement next = driver.findElement(By.cssSelector(".k-nav-next"));

		next.click();

		// Intentional pause for 2 seconds.
		Thread.sleep(2000);
	}

	public void endTest() {
		driver.close();
	}
}