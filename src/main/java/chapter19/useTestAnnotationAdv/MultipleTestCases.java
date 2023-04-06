package main.java.chapter19.useTestAnnotationAdv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleTestCases {
	@Test
	public void cTest() {
		System.out.println("Test C");
		Assert.assertTrue(true);
	}

	@Test
	public void aTest() {
		System.out.println("Test A");
		Assert.assertTrue(true);
	}

	@Test
	public void bTest() {
		System.out.println("Test B");
		Assert.assertTrue(true);
	}
}
