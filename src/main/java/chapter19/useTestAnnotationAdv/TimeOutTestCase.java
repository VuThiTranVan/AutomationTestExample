package main.java.chapter19.useTestAnnotationAdv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeOutTestCase {
	@Test(timeOut = 1000)
	public void testcaseTimeout() throws Exception {
		Thread.sleep(3000);
		Assert.assertTrue(true);
	}
}
