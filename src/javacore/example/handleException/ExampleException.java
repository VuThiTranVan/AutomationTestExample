package javacore.example.handleException;

public class ExampleException {
	public void division(int num1, int num2) {
		// java.lang.ArithmeticException here
		// and not caught hence propagate to method1.
		System.out.println(num1 / num2);
		System.out.println("line code in division method");
	}

	/**
	 * gọi method mà không có try catch
	 * 
	 * @param num1,
	 *            num2
	 * @param division
	 *            (num1, num2)
	 * 
	 *            return exception => dừng chương trình
	 */

	public void call_method_division(int num1, int num2) {
		// not caught here and hence propagate to method2.
		division(num1, num2);
		System.out.println("after call method division");
	}

	/**
	 * call method division, và tự try tại bản thân mình
	 * 
	 * @param num1
	 * @param num2
	 */
	public void call_method_and_try_catch_myself(int num1, int num2) {
		try {
			division(num1, num2);
			System.out.println("line code after method division");
		} catch (Exception e) {// caught exception here.
			System.out.println("Exception Handled");
		}
	}

	/**
	 * Cả 2 method đều catch
	 * 
	 * @param args
	 */
	public void division_has_try_catch(int num1, int num2) {
		// java.lang.ArithmeticException here
		// and not caught hence propagate to method1.
		try {
			System.out.println(num1 / num2);
		} catch (ArithmeticException e) {
			System.out.println("Catch exception of division_has_try_catch");
		}
	}

	public void call_method_both_try_catch(int num1, int num2) {
		try {
			division_has_try_catch(num1, num2);
			System.out.println("line code after method division");
		} catch (Exception e) {// caught exception here.
			System.out.println("Exception Handled");
		}
	}

	public static void main(String[] args) {
		ExampleException ex = new ExampleException();

		// ví dụ 1: có lỗi ko được chia cho 0 => dừng chương trình
		// ex.division(10, 0);

		ex.call_method_and_try_catch_myself(1, 0);
		
		System.out.println("\n___________");
		ex.call_method_both_try_catch(1, 0);

	}

}
