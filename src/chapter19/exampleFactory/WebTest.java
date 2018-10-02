package chapter19.exampleFactory;

import org.testng.annotations.Test;

public class WebTest {
	private int m_numberOfTimes;

	public WebTest(int numberOfTimes) {
		m_numberOfTimes = numberOfTimes;
	}

	public WebTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testServer() {
		System.out.println("\n====m_numberOfTimes " + m_numberOfTimes);
		for (int i = 0; i < m_numberOfTimes; i++) {
			System.out.println("hello baby");
		}
	}
}
