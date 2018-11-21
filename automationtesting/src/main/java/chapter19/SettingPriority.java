package chapter19;

import org.testng.annotations.*;

/**
 * Example for [7. Working with TestNG]
 * 
 * @author FRAMGIA\vu.thi.tran.van
 *
 */
public class SettingPriority {
	@Test(priority = 2)
	public void method1() {
	}

	@Test(priority = 1)
	public void method2() {
	}

	@Test(priority = 0)
	public void method3() {
	}
}
