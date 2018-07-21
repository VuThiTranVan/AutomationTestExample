package selenium.webdriver.practice07;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice_Session_07 {
	public static void main(String[] args) {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
//		WebDriver driver = new FirefoxDriver();
//		driver.get(VariableSettings.PATH_WEBTEST_ACCESS_LINK);

		
		// demo_1(driver);
		// demo_2(driver);
		// demo_3(driver);
		// demo_4();
//		demo_5();
//		demo_5_Step2();
//		demo_6();
		demo_7();
	}

	/**
	 * Demo 1: Using By.linkText() find by text "Bank Project" return: title is
	 * Guru99 Bank Home Page
	 */
	static void demo_1(WebDriver driver) {
		driver.findElement(By.linkText("Bank Project")).click();
		System.out.println(driver.getTitle());
	}

	/**
	 * Demo 02: Same link text with By.linkText()
	 * 
	 */
	static void demo_2(WebDriver driver) {
		driver.findElement(By.linkText("click here")).click();
		System.out.println("Title of page is: " + driver.getTitle());
	}

	/**
	 * Demo 03: Same link text with By.partialLinkText()
	 */
	static void demo_3(WebDriver driver) {
		// List<WebElement> elements_with_text_project =
		// driver.findElements(By.partialLinkText("here"));
		driver.findElement(By.partialLinkText("here")).click();
		System.out.println("Title of page is: " + driver.getTitle());
	}

	/**
	 * Demo 04: Case-sensitive Using:
	 * AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html
	 */
	public static void demo_4() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/vuthitranvan/vanvtt/Automation%20Test/WebDriver%20with%20java/github_selenium_training/AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html");
		
		driver.findElement(By.partialLinkText("link")).click();
		System.out.println("Title of page is: " + driver.getTitle());
	}

	/**
	 * Demo 05: Get all link into this Page
	 * AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html
	 */
	public static void demo_5() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/vuthitranvan/vanvtt/Automation%20Test/WebDriver%20with%20java/github_selenium_training/AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html");
		
		 List<WebElement> a_tags_project = driver.findElements(By.tagName("a"));
		 a_tags_project.forEach(item->System.out.println(item.getText()));
	}
	
	/**
	 * Demo 05 - step 2: Get all link into this Page
	 * AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html
	 */
	public static void demo_5_Step2() {
		String baseUrl = "file:///home/vuthitranvan/vanvtt/Automation%20Test/WebDriver%20with%20java/github_selenium_training/AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html";
		WebDriver driver = new FirefoxDriver();

		String underConsTitle = "Under Construction: Mercury Tours";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(baseUrl);
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;

		// extract the link texts of each link element
		for (WebElement e : linkElements) {
			linkTexts[i] = e.getText();
			i++;
		}

		// test each link
		for (String t : linkTexts) {
			driver.findElement(By.linkText(t)).click();
			System.out.println("Click " + t + "\n\tReturn tile: " + driver.getTitle());
			if (driver.getTitle().equals(underConsTitle)) {
				System.out.println(t +" is under construction.");
			} else {
				System.out.println("\t" + t +" is working.");
			}
			driver.navigate().back();
		}
	}
	
	/**
	 * Demo 06: Get all link into this Page
	 * AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html
	 */
	public static void demo_6() {
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///home/vuthitranvan/vanvtt/Automation%20Test/WebDriver%20with%20java/github_selenium_training/AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html");
		driver.findElement(By.partialLinkText("Inside")).click();					
        System.out.println(driver.getTitle());					
        driver.navigate().back();			
        driver.findElement(By.partialLinkText("Outside")).click();				
        System.out.println(driver.getTitle());
	}
	
	private static void demo_7() {
		String baseUrl = "https://www.google.com/search?source=hp&ei=2rFSW7vYLdXp-QbanbLwAQ&q=selennium+&oq=selennium+&gs_l=psy-ab.3..0i13k1l10.5880.8423.0.9199.11.10.1.0.0.0.211.1096.6j3j1.10.0....0...1c.1j4.64.psy-ab..0.11.1091...0j0i131k1j0i10k1j0i30k1j0i10i30k1.0.luO9aMA79NE";

		WebDriver driver = new FirefoxDriver();
		driver.get(baseUrl);
		System.out.println("\n");
		
		System.out.println("Before click: Title is " + driver.getTitle());
		driver.findElement(By.cssSelector("#logo")).click();
		System.out.println("After click: Title is " + driver.getTitle());
	}
}
