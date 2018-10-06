package chapter19.EleniumAndTesstNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public abstract class CommonTestCase {
	public static WebDriver driver = null;

	// https://stackoverflow.com/questions/49741876/how-to-disable-push-notifications-using-selenium-for-firefox?noredirect=1&lq=1
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

		// System.setProperty("", "");
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("disable-infobars");
		// driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("http://stg-recruit.framgia.vn/");
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void end() {
		driver.quit();
	}

	@DataProvider
	public static Object[][] SetLogin() {

		return new Object[][] { { "vanvtt.soft@gmail.com", "Aa123456789" } };

	}

	public void testLogin(String email, String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#u_0_2")));
		WebElement btnLogin = driver.findElement(By.cssSelector("#u_0_2"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btnLogin.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement txtEmail = driver.findElement(By.cssSelector("input[name='email']"));
		txtEmail.sendKeys(email);

		WebElement txtPass = driver.findElement(By.cssSelector("input[name='pass']"));
		txtPass.sendKeys(pass);
		WebElement buttonLogin = driver.findElement(By.cssSelector("button[name='login']"));

		System.out.println("pas " + txtPass.getText());
		buttonLogin.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
