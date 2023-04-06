package main.java.chapter19;

import org.testng.annotations.Test;

/**
 * Example for [7. Working with TestNG] - Dependent Test
 * 
 * @author Sun*\vu.thi.tran.van
 *
 */
public class Dependent {

	@Test(dependsOnMethods = { "OpenBrowser" })
	public void SignIn() {
		System.out.println("Execute second (SignIn)");
	}

	@Test
	public void OpenBrowser() {
		System.out.println("Execute first (Open Browser)");
	}

	@Test(dependsOnMethods = { "SignIn" })
	public void LogOut() {
		System.out.println("Execute third (Log Out)");
	}
}