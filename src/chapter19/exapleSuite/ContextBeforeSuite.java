package chapter19.exapleSuite;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

/**
 * 
 * @BeforeSuite with ITestContext parameter
 * 
 * Nếu muốn setting param cho method @BeforeSuite thì dùng ITesstContext 
 * A @BeforeSuite method can be declared with a parameter of type ITestContext
 * 
 * Một số example: https://www.programcreek.com/java-api-examples/?api=org.testng.annotations.BeforeSuite
 * 
 * context.getSuite().setAttribute("author", "VanVTT");
 * context.getSuite().getAttribute("author"); => result is VanVTT
 * 
 * 
 *
 */
public class ContextBeforeSuite {
	@BeforeSuite
	public void beforeSuite(ITestContext context) {
		System.out.println("ContextBeforeSuite: before suite <b>" + context.getSuite().getName() + "</b");
	}
}
