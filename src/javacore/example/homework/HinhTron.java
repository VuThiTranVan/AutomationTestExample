package javacore.example.homework;

public class HinhTron extends HinhHoc {
	private static final double PI = 3.14;
	private int r;

	public HinhTron(int r) {
		this.r = r;
	}

	public HinhTron() {
	}

	@Override
	void displayInfo() {
		System.out.println("____Hinh Tron");
		System.out.println("Ban kinh: " + getR());

	}

	@Override
	public void tinhDienTich() {
		System.out.println("Dien tich: " + PI * getR() * getR());
	}

	@Override
	public void tinhChuVi() {
		System.out.println("Chu Vi: " + PI * getR() * 2);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

}
