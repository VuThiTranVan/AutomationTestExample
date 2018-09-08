package javacore.example.handleException;

/**
 * Có 2 cách để tại bản thân method đó ko phải xử lý exception đó là:
 * Ném exception cho method gọi nó
 * => Có 2 nơi giúp chúng ta làm điều đó với 2 method là Throws và throw
 * 
 *  1.throw: 
 *     1.1 ném trong phần thân của method (ko phải trong catch)
 *         throw new Exception
 *     1.2 ném trong phần catch
 *        vì vào catch, tức là biết đó là lỗi gì thì nên chỉ đích danh lỗi đó, chứ ko cần new Exception mới như 1.1
 *        throw e
 *   
 *  2. Throws
 *     Ném trên phần chữ ký (tên) của method
 *          void name_method(param) throws ArithmeticException [, exception 2, ...]
 *          
 * Ngoài ra, nếu muốn tự định nghĩa 1 exception thì chỉ cần tạo class exception của mình và extends từ class Exception
 *   
 * @author FRAMGIA\vu.thi.tran.van
 *
 */
public class ExampleThrowAndThrows {
	// tu minh raise exception
	static void selfRaiseException(int num1, int num2) {
		try {
			if (num2 == 0)

				throw new ArithmeticException("Khong duoc chia cho 0 nhe!");
			else
				System.out.println(num1 / num2);

		} catch (ArithmeticException e) {
			System.out.println("handle o catch: " + e.getMessage());
		}
	}

	static void mymethod(int num1, int num2) {
		try {

			System.out.println(num1 / num2);
			System.out.println("Call My method");
		} catch (ArithmeticException e) {
			System.out.println("mymethod - handle o catch: " + e.getMessage());
		}
	}

	/**
	 * example call method Throws
	 * 
	 * @param num1
	 * @param num2
	 * @throws ArithmeticException
	 */
	static void mymethodUseThrows(int num1, int num2) throws ArithmeticException {
		System.out.println(num1 / num2);
		System.out.println("mymethodUseThrows line 2");
	}

	static void callMymethodUseThrows(int num1, int num2) {
		System.out.println("Call mymethodUseThrows");
		mymethodUseThrows(num1, num2);
		System.out.println("callMymethodUseThrows line 3");
	}

	/**
	 * example call method throw
	 * 
	 * @param num1
	 * @param num2
	 * @throws ArithmeticException
	 */
	static void mymethodUseThrow(int num1, int num2) {
		try {
			System.out.println(num1 / num2);
			System.out.println("mymethodUseThrow - mymethodUseThrow line 2");
		} catch (ArithmeticException e) {
			throw e;
		}
	}

	static void callMymethodUseThrow(int num1, int num2) {
		System.out.println("callMymethodUseThrow - Call mymethodUseThrow");
		mymethodUseThrow(num1, num2);
		System.out.println("callMymethodUseThrow - callMymethodUseThrow line 3");
	}

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 0;

		selfRaiseException(num1, num2);
		mymethod(num1, num2);

		// callMymethodUseThrows(num1, num2); // code này nhận Throws nên sẽ
		// lỗi, comment để chạy method bên dưới

		callMymethodUseThrow(num1, num2);
	}

}
