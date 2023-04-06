package main.java.chapter19.exapleSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * 
 * @BeforeSuite methods shouldn’t run more than once even when used in Factory
 * 
 */
public class TestClassFactory {
	int data;

	public TestClassFactory() {
	};

	public TestClassFactory(int data) {
		this.data = data;
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println(" in before suite method");
	}

	@Test
	public void testMethod() {
		System.out.println(data);
	}

	@Factory
	public Object[] getData() {
		System.out.println("in factory method");
		return new Object[] { new TestClass("123") };
	}

	// TestClassFactory below defines a factory method createTestClass.
	// This factory method returns an array of two objects of TestClass class.
	@Factory
	public Object[] createTestClass() {
		return new Object[] { new TestClass("1"), new TestClass("2") };
	}

}
