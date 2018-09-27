package chapter19.exapleSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class ChildTestClass2 {
	@BeforeSuite
	@Parameters("param")
	public void beforeSuite(String p) {
		System.out.println("ChildTestClass2: before suite " + p);
	}
}
