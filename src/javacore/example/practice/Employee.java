package javacore.example.practice;

import java.util.List;

public abstract class Employee {
	private String code;
	private String name;
	private String gender;
	private List<String> certificateForJobs;

	public Employee(String code, String name, String gender, List<String> certificateForJobs) {
		this.code = code;
		this.name = name;
		this.gender = gender;
		this.certificateForJobs = certificateForJobs;
	}

	public Employee(String name, String gender, List<String> certificateForJobs) {
		this.name = name;
		this.gender = gender;
		this.certificateForJobs = certificateForJobs;
	}

	public Employee() {
	}

	public void displayInfo() {
		System.out.println("\n____ Hiển thị thông tin Nhân viên _____");
		System.out.println("Code: " + code + "\nName: " + name + "\nGender: " + gender);
		System.out.println("No\t Name");
		for (int i = 0; i < certificateForJobs.size(); i++) {
			System.out.println(i + "\t" + certificateForJobs.get(i));
		}
	}

	public abstract void working();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<String> getCertificateForJobs() {
		return certificateForJobs;
	}

	public void setCertificateForJobs(List<String> certificateForJobs) {
		this.certificateForJobs = certificateForJobs;
	}

}
