package javacore.example.staticKeyword;

public class StaticKeyword {

	/**
	 * biến count lấy bộ nhớ tại thời điểm tạo đối tượng, mỗi đối tượng sẽ có
	 * bản sao của biến instance, nếu biến count được tăng lên, nó sẽ không ảnh
	 * hướng đến các đối tượng khác. Vì thế mỗi đối tượng sẽ có giá trị 1 trong
	 * biến count.
	 */
	// int count = 0;

	/**
	 * biến static sẽ lấy bộ nhớ chỉ một lần, nếu bất cứ đối tượng nào thay đổi
	 * giá trị của biến static, nó sẽ vẫn ghi nhớ giá trị của nó.
	 */
	static int count = 0;

	public StaticKeyword() {

	}

	public void visit() {
		count++;
		this.print();
	}

	public void print() {
		System.out.println("count = " + count);
	}

	public static void main(String[] args) {
		StaticKeyword c1 = new StaticKeyword();
		c1.visit();
		StaticKeyword c2 = new StaticKeyword();
		c2.visit();
		StaticKeyword c3 = new StaticKeyword();
		c3.visit();
	}
}
