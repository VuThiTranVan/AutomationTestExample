package javacore.example.Inheritance;

import javacore.example.Inheritance.NongDan;

public class RunTest {

	public static void main(String[] args) {
		System.out.println("________________Person Class__________________");
		Person person = new Person("Duc Quoc", "Nam", "Quang Tri");
		person.introduceMyself();
		person.displayInfo("person");

		// Thao tac voi class NongDan
		System.out.println("\n\n________________NongDan Class __________________");
		NongDan nongDan1 = new NongDan();
		nongDan1.setName("Chien Lay");
		nongDan1.setAddress("Da Nang");
		nongDan1.setGender("Chua xac dinh");
		nongDan1.introduceMyself();
		nongDan1.displayInfo("nongDan1");

		// Thao Tac voi Class SinhVien
		System.out.println("\n\n________________SinhVien Class __________________");
		SinhVien sinhVien1 = new SinhVien("Bach Khoa");
		sinhVien1.introduceMyself();
		sinhVien1.displayInfo("sinhVien1");

		SinhVien sinhVien2 = new SinhVien("Hai Thanh", "Nam", "Ha Tinh", "Bach Khoa Ha Noi");
		sinhVien2.introduceMyself();
		sinhVien2.displayInfo("sinhVien2");

		SinhVien sinhVien3 = new SinhVien("Hai Thanh", "Nam", "Ha Tinh");
		sinhVien3.introduceMyself();
		sinhVien3.displayInfo("sinhVien3");

		// Thao Tac voi Class Nhan Vien Van Phong
		System.out.println("\n\n________________NhanVienVanPhong Class __________________");
		NhanVienVanPhong developer1 = new NhanVienVanPhong("Huu Tien", "Nam", "Ha Noi", "Framgia", "Java");
		developer1.introduceMyself();
		developer1.displayInfo("developer1");
		developer1.working("coding");
		NhanVienVanPhong comtor = new NhanVienVanPhong("Thuy Duong", "Nu", "Hue", "Unisoft", "Japanese N2");
		comtor.introduceMyself();
		comtor.displayInfo("comtor");
		comtor.working("Dich thuat tai lieu");

		// Object được start từ class cha
		// Ví dụ về tính đa hình
		Person sinhvien = new SinhVien("Minh Tuan", "Nam", "Ha Noi", "Bach Khoa");
		Person nhanVienVanPhong = new NhanVienVanPhong("Viet Khoa", "Nam", "Ha Noi", "Naitei Framgia", "Framgia");
		sinhvien.displayInfo("Sinh Vien");
		nhanVienVanPhong.displayInfo("nhan vien van phong");

	}

}
