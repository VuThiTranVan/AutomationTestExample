package javacore.example.workingClasses;

public class RunExample {
	public static void main(String[] args) {
		// Ví dụ 1:
		Truong pnv = new Truong();
		pnv.display();

		pnv.setName("Truong pnv");
		pnv.setAddress("Son Tra");
		pnv.display();
		System.out.println("___________________\n");

		SinhVien sv = new SinhVien("VanVTT", "Nu");
		sv.setTruongHoc(pnv);
		sv.display();

		System.out.println("___________________\n");
		SinhVien sv2 = new SinhVien();
		// setting dữ liệu
		sv2.setName("Mai Hoa");
		sv2.setGender("Nu");
		sv2.setTruongHoc(new Truong());
		sv.getTruongHoc().setName("Truong Bach Khoa");
		sv2.getTruongHoc().setAddress("Hoa Khanh");

		// hiển thị
		System.out.println("Thông tin sinh viên 2");
		System.out.println("\t Tên Sinh Viên: " + sv2.getName());
		System.out.println("\t Giới tính Sinh Viên: " + sv2.getGender());
		System.out.println("\t thông tin trường học: \n\tName: " + sv2.getTruongHoc().getName() + "; Địa chỉ: "
				+ sv2.getTruongHoc().getAddress());

	}
}
