package chapter07;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.VariableSettings;

public class ReadingATableExample {

	public static void main(String[] args) {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();
		example_1(driver);
		example_2(driver);
		example_3(driver);

	}

	public static void example_1(WebDriver driver) {
		String base_url = new File("resources/chapter07/ReadingTable_Example1.html").getAbsolutePath().toString();
		driver.get(VariableSettings.ROOT_LINK + base_url);

		System.out.println("\n\n");
		System.out.println("ways 1: " + driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText());
		System.out.println("ways 2: " + driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
		System.out.println("with path absolute: " + driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText());
	}

	public static void example_2(WebDriver driver) {
		String base_url = new File("resources/chapter07/ReadingTable_Example2.html").getAbsolutePath().toString();
		driver.get(VariableSettings.ROOT_LINK + base_url);

		System.out.println("\n\n");

		System.out.println(
				"ways 1: " + driver.findElement(By.xpath("//table/tbody/tr/td[2]/table/tbody/tr/td[2]")).getText());
		System.out.println(
				"ways 2: " + driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]")).getText());
	}

	public static void example_3(WebDriver driver) {
		String base_url = new File("resources/chapter07/ReadingTable_Example3.html").getAbsolutePath().toString();
		driver.get(VariableSettings.ROOT_LINK + base_url);
		System.out.println("\n\n");

		System.out.println(
				"text: " + driver.findElement(By.xpath("//table[@title=\"inner-table\"]/tbody/tr/td[2]")).getText());
	}
}
