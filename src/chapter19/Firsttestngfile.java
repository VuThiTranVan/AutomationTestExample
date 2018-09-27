package chapter19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Example for [5. Create testcase using TestNG]
 * 
 * @author FRAMGIA\vu.thi.tran.van
 *
 */
public class Firsttestngfile {
	public String baseUrl = "https://wsm.framgia.vn";
	public WebDriver driver;

	@Test
	public void verifyHomepageTitle() {
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		String expectedTitle = "Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
	}
}
