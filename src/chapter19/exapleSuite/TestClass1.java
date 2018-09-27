package chapter19.exapleSuite;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Example of @BeforeSuite
 * 
 * A @BeforeSuite annotated method represents an event before the suite starts,
 * so all the @BeforeSuite methods will be executed before the first test
 * declared within the test element is invoked.
 *
 */
public class TestClass1 {
	// chạy trước tiên
	@BeforeSuite
	public void suiteSetup1() {
		System.out.println("testClass1.suiteSetup1: before suite");
	}

	// chạy sau khi chạy @BeforeSuite
	@BeforeTest
	public void beforeTest() {
		System.out.println("testClass1: before test");
	}

	@Test
	public void unitLevel1() {
		System.out.println("testClass1: Unit level1 testing");
	}

	@Test
	public void unitLevel2() {
		System.out.println("testClass1: Unit level2 testing");
	}

	// chạy sau khi chạy @BeforeClass
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("testClass1: before method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("testClass1: after method");
	}

	// chạy sau khi chạy @BeforeTest
	@BeforeClass
	public void beforeClass() {
		System.out.println("testClass1: before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("testClass1: after class");
	}

	@AfterSuite
	public void cleanupSuite() {
		System.out.println("testClass1.cleanupSuite: after suite");
	}
}
