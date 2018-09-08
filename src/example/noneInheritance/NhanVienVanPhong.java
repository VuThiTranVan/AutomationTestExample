package example.noneInheritance;

public class NhanVienVanPhong {
	private String name;
	private String gender;
	private String address;
	private String company;
	private String certificateForJob;

	public NhanVienVanPhong() {
	}

	public NhanVienVanPhong(String name, String gender, String address, String company, String certificateForJob) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.company = company;
		this.certificateForJob = certificateForJob;
	}

	public void displayInfo(String object_name) {
		System.out.println("\n Toi la object " + object_name);
		System.out.println("\tName: " + getName());
		System.out.println("\tGender: " + getGender());
		System.out.println("\tAddress: " + getAddress());
		System.out.println("\tCompany name: " + getCompany());
		System.out.println("\tCertification: " + getCertificateForJob());
		System.out.println("__________DONE__________");
	}
	
	public void working(String nameJob) {
		System.out.println("Cong Viec cua toi la: " + nameJob);
	}

	public void introduceMyself() {
		System.out.println("\n_____Toi la Nhan Vien Van Phong ______");
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCertificateForJob() {
		return certificateForJob;
	}

	public void setCertificateForJob(String certificateForJob) {
		this.certificateForJob = certificateForJob;
	}
}
