package example.noneInheritance;

public class RunTest {

	public static void main(String[] args) {
		SinhVien sv = new SinhVien("Mai Hoa", "Nu", "Quang Tri", "Back Khoa");
		sv.introduceMyself();
		sv.displayInfo("sv");
		
		NhanVienVanPhong developer = new NhanVienVanPhong("Tran Van", "Nu", "Quang Nam", "Framgia", "Java");
		developer.introduceMyself();
		developer.displayInfo("developer");
		developer.working("Coding project");
		
		NhanVienVanPhong comtor = new NhanVienVanPhong("Thuy Duong", "Nu", "Quang Tri", "Unisoft", "Japanese N2");
		comtor.introduceMyself();
		comtor.displayInfo("comtor");
		comtor.working("Translate document");
		
		NongDan nongDan = new NongDan("Chien Lay", "Nam", "Hue");
		nongDan.introduceMyself();
		nongDan.displayInfo("nongDan");
	}

}
