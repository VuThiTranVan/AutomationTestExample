package example.Inheritance.abstractClass;

public abstract class AEmployer {
	private String name;
	private String gender;
	private String address;
	private String certificateForJob;

	public abstract String working();

	public void displayInfo(String object_name) {
		System.out.println("\n Toi la object " + object_name);
		System.out.println("\tName: " + getName());
		System.out.println("\tGender: " + getGender());
		System.out.println("\tAddress: " + getAddress());
		System.out.println("\tCertification: " + getCertificateForJob());
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

	public String getCertificateForJob() {
		return certificateForJob;
	}

	public void setCertificateForJob(String certificateForJob) {
		this.certificateForJob = certificateForJob;
	}
}
