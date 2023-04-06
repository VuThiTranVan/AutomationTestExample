package main.java.chapter19.exapleSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class ChildTestClass1 {
	@BeforeSuite
	@Parameters("param")
	public void beforeSuite(String p) {
		System.out.println("ChildTestClass1: before suite " + p);
	}
}
