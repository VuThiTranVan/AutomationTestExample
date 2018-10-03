package examlefinal.loginwsm;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import examlefinal.loginwsm.util.Setting;
import examlefinal.loginwsm.util.XLSHelper;

public class TestLogin extends CommonTestCase {

	/**
	 * Verify login unsuccessfully
	 */
	@DataProvider
	public Object[][] SetLogin() {
		Object[][] data = XLSHelper.retrieveCellsMulti(Setting.getSetting(Setting.DATA_FILE), 2, 2);
		return data;
	}

	// User is not able to Login with blank Email or Password
	@Test(priority = 1)
	public void testLogin() {
		WebElement btnLogin = driver
				.findElement(By.cssSelector("body > div.wsm-index > div.slide-wsm-content.display-none > a"));
		btnLogin.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement txtEmail = driver.findElement(By.cssSelector("#user_email"));
		txtEmail.sendKeys("");

		WebElement txtPass = driver.findElement(By.cssSelector("#user_password"));
		txtPass.sendKeys("");

		WebElement buttonLogin = driver.findElement(By.cssSelector("#devise-login-form > div:nth-child(7) > button"));
		buttonLogin.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement message_email = driver.findElement(By.cssSelector("#user_email-error"));
		WebElement message_pasword = driver.findElement(By.cssSelector("#user_password-error"));

		String expect_result_email = "Email is required";
		String expect_result_password = "Password is required";

		assertEquals(message_email.getText(), expect_result_email);
		assertEquals(message_pasword.getText(), expect_result_password);

	}

}
