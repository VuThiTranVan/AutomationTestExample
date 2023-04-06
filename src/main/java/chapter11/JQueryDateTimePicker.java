package main.java.chapter11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.VariableSettings;

public class JQueryDateTimePicker {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/resources/demos/datepicker/other-months.html");
		WebElement calElement = driver.findElement(By.id("datepicker"));
		calElement.click();
		String date = "15-January-2018";
		String spilitter[] = date.split("-");
		String eday = spilitter[0];

		String oMonth = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
		String oYear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();
		System.out.println(oMonth);
		System.out.println(oYear);

		WebElement next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));// Next
																							// Button

		for (int i = 0; i < 4; i++) {
			Thread.sleep(2000);
			next.click();
			oMonth = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
			oYear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();
			next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
		}

		System.out.println("M here");

		WebElement tBody = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody"));
		List<WebElement> tRow = tBody.findElements(By.tagName("tr"));

		for (int i = 1; i < tRow.size(); i++) {
			List<WebElement> tColoumn = tRow.get(i).findElements(By.tagName("td"));

			for (int j = 1; j < tColoumn.size(); j++) {
				String oDay = driver
						.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[" + i + "]/td[" + j + "]/a"))
						.getText();
				if (eday.equals(oDay)) {
					driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.click();
					break;
				}
			}
		}

	}
}
