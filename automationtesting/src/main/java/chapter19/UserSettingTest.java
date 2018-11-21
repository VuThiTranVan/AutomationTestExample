package chapter19;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.VariableSettings;

public class UserSettingTest {
	private WebDriver browser;
	private String baseUrl;

	@Test(description = "Launches the Selenium Master Test Application and Login")
	public void launchSiteAndLogin() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);
		browser.get(baseUrl + "/seleniummastertestapp/index.php");
		for (int second = 0;; second++) {
			if (second >= 60)
				Assert.fail("timeout");
			try {
				if (isElementPresent(By.cssSelector("img[alt=\"Selenium Master\"]")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		browser.findElement(By.id("login_login_username")).clear();
		browser.findElement(By.id("login_login_username")).sendKeys("test");
		browser.findElement(By.id("login_login_password")).clear();
		browser.findElement(By.id("login_login_password")).sendKeys("XXXX"); // password
																				// is
																				// omitted
		browser.findElement(By.id("login_submit")).click();
		assertEquals(browser.findElement(By.cssSelector("ul.cr > li > a")).getText(), "Test Selenium");
	}

	@Test(description = "Navigates to the User Settings page")
	public void openUserSettingPage() throws InterruptedException {
		browser.findElement(By.linkText("Settings")).click();

		for (int second = 0;; second++) {
			if (second >= 60)
				Assert.fail("timeout");
			try {
				if (isElementPresent(By.id("login_login_username")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		browser.findElement(By.id("login_login_username")).clear();
		browser.findElement(By.id("login_login_username")).sendKeys("test");
		browser.findElement(By.id("login_login_password")).clear();
		browser.findElement(By.id("login_login_password")).sendKeys("XXXXX");// password
																				// is
																				// omitted
		browser.findElement(By.id("login_submit")).click();

		for (int second = 0;; second++) {
			if (second >= 60)
				Assert.fail("timeout");
			try {
				if (isElementPresent(By.xpath("//input[@value='auth']")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		assertTrue(isElementPresent(By.xpath("//input[@value='auth']")));

	}

	@Test(description = "Change a User settings to add as a friends after authorization")
	public void ChangeUserSettings() {
		browser.findElement(By.xpath("//input[@value='auth']")).click();
		browser.findElement(By.id("accountprefs_submit")).click();
		assertEquals(browser.findElement(By.cssSelector("div.ok")).getText(), "Preferences saved");
	}

	@Test(description = "Log out the system")
	public void Logout() throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				Assert.fail("timeout");
			try {
				if (isElementPresent(By.linkText("Logout")))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		browser.findElement(By.linkText("Logout")).click();
		assertTrue(isElementPresent(By.id("login_login_username")));
	}

	@BeforeClass(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) {
		baseUrl = "http://www.seleniummaster.com";

		try {

			browser = new FirefoxDriver();
			browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("Can't start Web Driver", e);
		}

	}

	@AfterClass
	public void setupAfterSuite() {
		browser.close();
		browser.quit();
	}

	private boolean isElementPresent(By by) {
		try {
			browser.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
