package javacore.exampleControlStatements;

public class SelectionStatements {

	public static void evenNumber(int n) {
		if (n % 2 == 0) {
			System.out.println(n + ": This is even number");
		}
		System.out.println("Ahihi hớt rồi\n\n");
	}

	public static void checkNumber(int n) {
		if (n >= 0) {
			System.out.println(n + ": This is positive number");
		} else {
			System.out.println(n + ": This is Negative number");
		}
	}

	public static void homNayLaThuMay(int day) {
		switch (day) {
		case 1:
			System.out.println("Sunday");
			break;// thoát khỏi switch case
		case 2:
			System.out.println("Monday");
			break;
		case 3:
			System.out.println("Tuesday");
			break;
		case 4:
			System.out.println("Wednesday");
			break;
		case 5:
			System.out.println("Thursday");
			break;
		case 6:
			System.out.println("Friday");
			break;
		case 7:
			System.out.println("Saturday");
			break;
		default:
			System.out.println("Invalid entry");
			break;
		}

	}

	public static void main(String[] args) {
		SelectionStatements.evenNumber(10);
		SelectionStatements.checkNumber(11);
		SelectionStatements.homNayLaThuMay(2);		
	}
}
