package main.java.chapter19.exapleSuite;

import org.testng.annotations.BeforeSuite;

/**
 * @Requirement
 * Have a parent suite that contains child suites.
 * Each child suite has one test class and each test class has one @BeforeSuite method.
 * The parent suite contains a common parameter called param which the @BeforeSuite methods of the child <b> suites share </b>.
 * 
 * @Results
 * Example of parent and child suites Khi run Parent Suite, thì
 *  parameter value set at parent suite is received by both the child suites
 *
 */
public class ParentTestClass {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("ParentTestClass: before suite");
	}
}
