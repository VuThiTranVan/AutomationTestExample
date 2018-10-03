package examlefinal.loginwsm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class CommonTestCase {
	public static WebDriver driver = null;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile testprofile = profile.getProfile("customfirefox");
		testprofile.setPreference("dom.webnotifications.enabled", false);
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, testprofile);
		FirefoxOptions opt = new FirefoxOptions();
		opt.merge(dc);
		driver = new FirefoxDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://wsm.framgia.vn");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void end() {
		driver.quit();
	}

//	@DataProvider
//	public Object[][] SetLogin() {
//		Object[][] data = XLSHelper.retrieveCellsMulti(Setting.getSetting(Setting.DATA_FILE), 2, 2);
//		return data;
//	}
//
//	public void testLogin(String email, String password) {
//		WebElement btnLogin = driver
//				.findElement(By.cssSelector("body > div.wsm-index > div.slide-wsm-content.display-none > a"));
//		btnLogin.click();
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		WebElement txtEmail = driver.findElement(By.cssSelector("#user_email"));
//		txtEmail.sendKeys(email);
//
//		WebElement txtPass = driver.findElement(By.cssSelector("#user_password"));
//		txtPass.sendKeys(password);
//
//		WebElement buttonLogin = driver.findElement(By.cssSelector("#devise-login-form > div:nth-child(7) > button"));
//		buttonLogin.click();
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//	}
}
