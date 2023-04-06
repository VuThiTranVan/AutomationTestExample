package main.java.chapter19.useTestAnnotationAdv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EnabledTestCase {
	@Test
	public void cTest() {
		System.out.println("Test C");
		Assert.assertTrue(true);
	}

	@Test(enabled = false)
	public void aTest() {
		System.out.println("Test A");
		Assert.assertTrue(true);
	}

	@Test(enabled = false)
	public void bTest() {
		System.out.println("Test B");
		Assert.assertTrue(true);
	}
}
