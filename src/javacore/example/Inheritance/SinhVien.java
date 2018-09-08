package javacore.example.Inheritance;

public class SinhVien extends Person {
	private String school;

	public SinhVien() {
		super();// day chinh la constructor ko tham so cua Class Person
	}

	public SinhVien(String name, String gender, String address) {
		super(name, gender, address);// day chinh la constructor ko tham so cua
										// Class Person
	}

	public SinhVien(String school) {
		super();
		this.school = school;
	}

	public SinhVien(String name, String gender, String address, String school) {
		super(name, gender, address);
		this.school = school;
	}

	@Override
	public void introduceMyself() {
		System.out.println("\n_____Toi la Sinh Vien ______");
	}

	@Override
	public void displayInfo(String object_name) {
		super.displayInfo(object_name);
		System.out.println("\tSchool: " + getSchool());
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
