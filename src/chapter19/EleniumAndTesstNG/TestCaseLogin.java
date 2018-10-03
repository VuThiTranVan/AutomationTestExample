package chapter19.EleniumAndTesstNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCaseLogin extends CommonTestCase {

	@Test(priority = 1, dataProvider = "SetLogin")
	public void testLogin(String email, String pass) {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("._1vp5")));

		System.out.println("account: " + account.getText());

		assertEquals(account.getText(), "Vu");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// CASE check name
	@Test(priority = 2)
	public void verifyAuthor() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement link_login = driver.findElement(By.cssSelector("._1vp5"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		link_login.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Xác thực xem đúng account mình đăng ký ko (Vu Van)
		WebElement text_on_search = driver.findElement(By.cssSelector("._2nlw"));
		String expected_account_name = "Vu Van";
		assertEquals(text_on_search.getText(), expected_account_name);
	}
}
