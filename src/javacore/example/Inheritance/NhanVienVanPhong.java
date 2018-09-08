package javacore.example.Inheritance;

public class NhanVienVanPhong extends Person {

	private String company;
	private String certificateForJob;

	public NhanVienVanPhong(String company, String certificateForJob) {
		super();
		this.company = company;
		this.certificateForJob = certificateForJob;
	}

	public NhanVienVanPhong(String name, String gender, String address, String company, String certificateForJob) {
		super(name, gender, address);
		this.company = company;
		this.certificateForJob = certificateForJob;
	}

	@Override
	public void introduceMyself() {
		System.out.println("\n_____Toi la Nhan Vien Van Phong ______");
	}

	@Override
	public void displayInfo(String object_name) {
		super.displayInfo(object_name);
		System.out.println("\tCompany name: " + getCompany());
		System.out.println("\tCertification: " + getCertificateForJob());
	}

	public void working(String nameJob) {
		System.out.println("Cong Viec cua toi la: " + nameJob);
	}

	public NhanVienVanPhong() {
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
