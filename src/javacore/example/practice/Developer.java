package javacore.example.practice;

public class Developer extends Employee implements OtherWork{

	@Override
	public void working() {
		System.out.println("Coding");
	}

	public void workingLaguage(String languages) {
		System.out.println("toi code voi ngon ngu: " + languages);
	}

	public void useLinux(boolean flag) {
		if (flag) {
			System.out.println("Da lam viec voi HDH Linux");
		} else {
			System.out.println("Chua lam viec voi HDH Linux");
		}
	}

	@Override
	public void requestOT() {
		System.out.println("tui co the request OT nek :D ");
		
	}

	@Override
	public void exportTimesheet() {
		System.out.println("Export timesheet to excel");
		
	}

}
