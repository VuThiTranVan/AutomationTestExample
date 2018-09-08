package javacore.example.workingClasses;

public class SinhVien {
	
	// variables
	private String name;
	private String gender;
	private Truong truongHoc;

	// constructors
	public SinhVien() {
	}

	/**
	 * Sẽ không tồn tại song song 2 constructor SinhVien(String name, String
	 * gender) và SinhVien(String ten, String gioiTinh)
	 */
	public SinhVien(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	public SinhVien(String name, String gender, Truong truongHoc) {
		this.name = name;
		this.gender = gender;
		this.truongHoc = truongHoc;
	}
	
	// methods
	public void display() {
		System.out.println("Thông tin Sinh Viên____");
		System.out.println("\tName: " + getName() + "\n\tGender: " + getGender());
		this.truongHoc.display(); // this này chỉ sử dụng được trong class - vì biến truongHoc là private
		// Cách khác: getTruongHoc.display();
		// Code này có nghĩa là object truongHoc đang call method display ở class Truong nhé
	}

	/**
	 * Các line code từ 42 đến hết - nó là methods
	 * Nhưng mục đích method này tạo ra để set và get dữ liệu cho các variable có scope là PRIVATE
	 * Nên khi đặt tên các method thì tránh đặt bắt đầu là set* hoặc get* vì sẽ gây nhầm lẫn là mình đang dùng để set get cho variable nào đó
	 * Đây chỉ là quy ước với nhau nhé
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Truong getTruongHoc() {
		return truongHoc;
	}

	public void setTruongHoc(Truong truongHoc) {
		this.truongHoc = truongHoc;
	}

}
