package main.java.chapter19.useTestAnnotationAdv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsTestCase {
	@Test(priority = 1)
	public void cTest() {
		System.out.println("Test C");
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	public void aTest() {
		System.out.println("Test A");
		Assert.assertTrue(true);
	}

	@Test(priority = 0, dependsOnMethods="aTest")
	public void bTest() {
		System.out.println("Test B");
		Assert.assertTrue(true);
	}
}
