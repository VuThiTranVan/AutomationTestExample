package chapter07;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.VariableSettings;

public class AccessingLinksExample {
	public static void main(String[] args) {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();
		example_1(driver);
		example_2(driver);
		example_3(driver);
		example_4(driver);
		example_5(driver);
		example_5_Step2(driver);
		example_6(driver);
		example_7(driver);
	}

	/**
	 * Example 01:
	 * Using By.linkText() find by text "Bank Project" return: title is Guru99 Bank Home Page
	 */
	static void example_1(WebDriver driver) {
		driver.get(VariableSettings.PATH_WEBTEST_ACCESS_LINK);
		driver.findElement(By.linkText("Bank Project")).click();
		System.out.println(driver.getTitle());
	}
	
	/**
	 * Example 02: Same link text with By.linkText()
	 * 
	 */
	static void example_2(WebDriver driver) {
		driver.get(VariableSettings.PATH_WEBTEST_ACCESS_LINK);
		driver.findElement(By.linkText("click here")).click();
		System.out.println("Title of page is: " + driver.getTitle());
	}

	/**
	 * Example 03: Same link text with By.partialLinkText()
	 */
	static void example_3(WebDriver driver) {
		driver.get(VariableSettings.PATH_WEBTEST_ACCESS_LINK);
		driver.findElement(By.partialLinkText("here")).click();
		System.out.println("Title of page is: " + driver.getTitle());
	}

	/**
	 * Example 04: Case-sensitive Using:
	 * reources/chapter07/AccessingLinks_4.html
	 */
	public static void example_4(WebDriver driver) {
		String base_url = new File("resources/chapter07/AccessingLinks_4.html").getAbsolutePath().toString();
		driver.get(VariableSettings.ROOT_LINK + base_url);		
		
		driver.findElement(By.partialLinkText("link")).click();
		System.out.println("Title of page is: " + driver.getTitle());
	}

	/**
	 * Example 05: Get all link into this Page
	 * reources/chapter07/AccessingLinks_4.html
	 */
	public static void example_5(WebDriver driver) {
		String base_url = new File("resources/chapter07/AccessingLinks_4.html").getAbsolutePath().toString();
		driver.get(VariableSettings.ROOT_LINK + base_url);
		
		 List<WebElement> a_tags_project = driver.findElements(By.tagName("a"));
		 a_tags_project.forEach(item->System.out.println(item.getText()));
	}
	
	/**
	 * Example 05 - step 2: Get all link into this Page
	 * AutomationTestExample/src/selenium/webdriver/practice07/linkpages.html
	 */
	public static void example_5_Step2(WebDriver driver) {
		String base_url = new File("resources/chapter07/AccessingLinks_4.html").getAbsolutePath().toString();
		driver.get(VariableSettings.ROOT_LINK + base_url);
		
		// Chỉ sử dụng khi máy chậm, cần nhiều time hơn để load
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
			
			String underConsTitle = "Under Construction: Mercury Tours";
			if (driver.getTitle().equals(underConsTitle)) {
				System.out.println(t +" is under construction.");
			} else {
				System.out.println("\t" + t +" is working.");
			}
			driver.navigate().back();
		}
	}
	
	/**
	 * Example 06: Get all link into this Page
	 * resources/chapter07/AccessingLinks_6.html
	 */
	public static void example_6(WebDriver driver) {
		String base_url = new File("resources/chapter07/AccessingLinks_6.html").getAbsolutePath().toString();
		driver.get(VariableSettings.ROOT_LINK + base_url);
		driver.findElement(By.partialLinkText("Inside")).click();					
        System.out.println(driver.getTitle());					
        driver.navigate().back();			
        driver.findElement(By.partialLinkText("Outside")).click();				
        System.out.println(driver.getTitle());
	}
	
	private static void example_7(WebDriver driver) {
		String baseUrl = "https://www.google.com/search?source=hp&ei=2rFSW7vYLdXp-QbanbLwAQ&q=selennium+&oq=selennium+&gs_l=psy-ab.3..0i13k1l10.5880.8423.0.9199.11.10.1.0.0.0.211.1096.6j3j1.10.0....0...1c.1j4.64.psy-ab..0.11.1091...0j0i131k1j0i10k1j0i30k1j0i10i30k1.0.luO9aMA79NE";
		driver.get(baseUrl);
		System.out.println("\n");
		
		System.out.println("Before click: Title is " + driver.getTitle());
		driver.findElement(By.cssSelector("#logo")).click();
		System.out.println("After click: Title is " + driver.getTitle());
	}
	
	private static void quite(WebDriver driver) {
		// driver.close();
		driver.quit();
	}
}
