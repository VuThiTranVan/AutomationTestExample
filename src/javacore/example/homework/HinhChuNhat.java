package javacore.example.homework;

public class HinhChuNhat extends HinhHoc {
	private int chieuDai;
	private int chieuRong;

	public HinhChuNhat(int chieuDai, int chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	public HinhChuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	void displayInfo() {
		System.out.println("____Hinh Vuong");
		System.out.println("Chieu dai: " + getChieuDai() + "; chieu rong: " + getChieuRong());

	}

	@Override
	void tinhDienTich() {
		System.out.println("Dien tich: " + getChieuDai() * getChieuRong());
	}

	@Override
	void tinhChuVi() {
		System.out.println("Chu Vi: " + (getChieuDai() + getChieuRong()) * 2);

	}

	void tinhChuVi(int dai, int rong) {
		System.out.println("Chu Vi: " + (dai + rong) * 2);

	}

	void tinhDienTich(

			int dai, int rong) {
		System.out.println("Dien tich: " + dai * rong);
	}

	public int getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}

}
