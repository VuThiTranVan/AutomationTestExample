package selenium.webdriver.practice07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice_session_07_Reading_Table {

	public static void main(String[] args) {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
//		demo_1();
//		demo_2();
		demo_3();

	}

	public static void demo_1() {
		String base_url = "file:///home/vuthitranvan/vanvtt/Automation%20Test/WebDriver%20with%20java/github_selenium_training/AutomationTestExample/src/selenium/webdriver/practice07/example-reading-table.html";
		WebDriver driver = new FirefoxDriver();
		driver.get(base_url);
		System.out.println("\n\n");
		System.out.println("aways 1: " + driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText());
		System.out.println("aways 2: " + driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
	}
	
	public static void demo_2() {
		String base_url = "file:///home/vuthitranvan/vanvtt/Automation%20Test/WebDriver%20with%20java/github_selenium_training/AutomationTestExample/src/selenium/webdriver/practice07/example-reading-table.html";
		WebDriver driver = new FirefoxDriver();
		driver.get(base_url);
		System.out.println("\n\n");
		
		System.out.println("aways 1: " + driver.findElement(By.xpath("//table/tbody/tr/td[2]/table/tbody/tr/td[2]")).getText());
		System.out.println("aways 2: " + driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]")).getText());
	}
	
	public static void demo_3() {
		String base_url = "file:///home/vuthitranvan/vanvtt/Automation%20Test/WebDriver%20with%20java/github_selenium_training/AutomationTestExample/src/selenium/webdriver/practice07/example-reading-table.html";
		WebDriver driver = new FirefoxDriver();
		driver.get(base_url);
		System.out.println("\n\n");
		
		System.out.println("text: " + driver.findElement(By.xpath("//table[@title=\"inner-table\"]/tbody/tr/td[2]")).getText());
	}
}
