package javacore.exampleControlStatements;

public class exampleLoops {
	public static void main(String[] args) {
		int i;
		for (i = 1; i < 10; i++) {
			System.out.println("i = " + i);
			SelectionStatements.homNayLaThuMay(i);
		}

		// while
		System.out.println("\n\n_______example while _______");
		int j = 1;
		while (j < 10) {
			System.out.println("j = " + j);
			SelectionStatements.homNayLaThuMay(j);
			j++;
		}

		System.out.println("\n\n_______example do while _______");
		// do while
		int k = 1;
		do {
			System.out.println("k = " + k);
			SelectionStatements.homNayLaThuMay(k);
			k++;
		} while (k < 10);
		
		// note do-while sẽ luôn thực hiện ít nhất là 1 lần
		k = 15;
		do {
			System.out.println("\nk = " + k);
			SelectionStatements.homNayLaThuMay(k);
			k++;
		} while (k < 10);
		
	}
}
