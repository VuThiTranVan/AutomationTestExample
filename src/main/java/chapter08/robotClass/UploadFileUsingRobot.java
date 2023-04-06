package main.java.chapter08.robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import util.VariableSettings;

public class UploadFileUsingRobot {
	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
		Thread.sleep(2500);
		Actions act = new Actions(driver);
		WebElement chooseFile = driver.findElement(By.id("fileupload1"));
		act.moveToElement(chooseFile).click().build().perform();
		Thread.sleep(2000);
		uploadFile("/home/vu.thi.tran.van/Pictures/Anh-mam-non.jpg");
	}

	public static void setClipBoard(String file) {
		StringSelection obj = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
	}

	public static void uploadFile(String filePath) throws AWTException {
		setClipBoard(filePath);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
}
