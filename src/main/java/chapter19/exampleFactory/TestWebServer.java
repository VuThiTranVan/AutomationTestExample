package main.java.chapter19.exampleFactory;

import org.testng.annotations.Test;

public class TestWebServer {
	@Test(parameters = { "number-of-times" })
	public void accessPage(int numberOfTimes) {
		System.out.println("\n====numberOfTimes " + numberOfTimes);
		while (numberOfTimes-- > 0) {
			System.out.println("hello baby");
		}
	}

}
