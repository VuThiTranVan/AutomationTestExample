package javacore.example.workingClasses;

public class Truong {
	private String name;
	private String address;

	/**
	 * Note:
	 * - Tên constructor là tên class
	 * - Không có giới hạn về constructor
	 * - Constructor phân biệt nhau bởi tham số: kiểu dữ liệu của tham số và số lượng tham số
	 * - Mặc định Java sẽ cung cấp cho mỗi class 1 constructor ko tham số: Truong(){}
	 * - Nếu ta tự định nghĩa constructor, thì constructor mặc định mà java hỗ trợ sẽ bị hủy bỏ (Nghĩa là chỉ có constructor của chúng ta khai báo thôi)
	 */
	
	public void display() {
		System.out.println("  Thong tin truong hoc____");
		System.out.println("\tName: " + getName() + "\n\tAddress: " + getAddress());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
