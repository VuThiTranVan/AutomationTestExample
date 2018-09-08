package javacore.example.practice;

import java.util.List;

public class Tester extends Employee {
	private boolean translateJapanese;

	public Tester() {

	}

	public Tester(String name, String gender, List<String> certificateForJobs, boolean otherInfo) {
		super(name, gender, certificateForJobs);
		this.translateJapanese = otherInfo;
	}

	@Override
	public void working() {
		System.out.println("Testing");
	}

	public boolean isTranslateJapanese() {
		return translateJapanese;
	}

	public void setTranslateJapanese(boolean translateJapanese) {
		this.translateJapanese = translateJapanese;
	}

}
