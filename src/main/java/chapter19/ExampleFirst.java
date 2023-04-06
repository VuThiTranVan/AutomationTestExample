package main.java.chapter19;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleFirst {
	@BeforeClass
	public void setUp() {
		System.out.println("before");
	}

	@Test(groups = { "fast" })
	public void aFastTest() {
		System.out.println("Fast test");
	}

	@Test(groups = { "slow" })
	public void aSlowTest() {
		System.out.println("Slow test");
	}
}
