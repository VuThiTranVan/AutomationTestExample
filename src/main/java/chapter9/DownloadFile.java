package main.java.chapter9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.VariableSettings;

public class DownloadFile {
	public static void main(String[] args) throws Exception {
		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.gecko.driver", VariableSettings.PATH_GECKO);

		// create a firefox options
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/xml,text/plain,text/xml, application/xls, image/jpeg");
		profile.setPreference("browser.download.dir", "/home/vu.thi.tran.van/Desktop");
		options.setProfile(profile);

		// Declare a FirefoxDriver with options above
		WebDriver driver = new FirefoxDriver(options);

		// comment the above 2 lines and uncomment below 2 lines to use Chrome
		// System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		String baseUrl = "https://edev.sun-asterisk.vn/users/sign_in";

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);

		// login as admin
		WebElement btnLogin = driver.findElement(By.className("btn-login"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(btnLogin));
		btnLogin.click();

		WebElement txt_email = driver.findElement(By.id("user_email"));
		txt_email.sendKeys("admin.wsm@framgia.com.edev.test");
		WebElement txtPass = driver.findElement(By.id("user_password"));
		txtPass.sendKeys("123456");
		WebElement btn_signin = driver.findElement(By.id("wsm-login-button"));
		btn_signin.click();
		Thread.sleep(500);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get("https://edev.sun-asterisk.vn/vi/dashboard/workspaces/6/manage_timesheets");

		Thread.sleep(5000);
		// button download file remote data
		Actions action = new Actions(driver);
		WebElement btnRemoteData = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[5]/div[1]/div[9]/div[3]/div/div/div/a[1]"));

		// click button download
		btnRemoteData.click();
		Thread.sleep(5000);
		// close Fire fox
		driver.close();
	}
}
