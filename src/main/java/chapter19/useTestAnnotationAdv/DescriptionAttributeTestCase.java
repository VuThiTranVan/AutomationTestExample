package main.java.chapter19.useTestAnnotationAdv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DescriptionAttributeTestCase {
	@Test(description = "Add Information of testcase")
	public void testcaseTitle() {
		System.out.println("Description Attribute");
		Assert.assertTrue(true);
	}
}
