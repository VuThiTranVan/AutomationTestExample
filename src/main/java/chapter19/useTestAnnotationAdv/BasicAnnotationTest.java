package main.java.chapter19.useTestAnnotationAdv;

import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class BasicAnnotationTest {
	public void testcase1() {
		System.out.println("Testcase public 1");
		Assert.assertTrue(true);
	}
	public void testcase2() {
		System.out.println("Testcase public 2");
		Assert.assertTrue(true);
	}

	private void testcasePrivate() {
		System.out.println("Private");
		Assert.assertTrue(true);
	}

}
