package main.java.chapter19;

import org.testng.annotations.Test;

/**
 * Example for [7. Working with TestNG] - Testcase Grouping
 * 
 * @author Sun*\vu.thi.tran.van
 *
 */


public class Grouping {
	@Test(groups = { "Car", "Car Sedan", "Scooter" })
	public void Sedan1() {}

	@Test(groups = { "Car Sedan" })
	public void Sedan2() {}

	@Test(groups = { "Car" })
	public void Car1() {}

	@Test(groups = { "Car" })
	public void Car2() {}

	@Test(groups = { "Scooter" })
	public void Scooter1() {}

	@Test(groups = { "Scooter" })
	public void Scooter2() {}

}


















