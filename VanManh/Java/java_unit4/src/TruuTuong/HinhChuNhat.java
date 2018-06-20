package TruuTuong;

public class HinhChuNhat extends Hinh {

	private double chieuDai;
	private double chieuRong;

	public HinhChuNhat(double cd, double cr) {
		this.chieuDai = cd;
		this.chieuRong = cr;
	}

	public double chuVi() {
		return (chieuDai + chieuRong) * 2;
	}

	public double dienTich() {
		return chieuDai * chieuRong;
	}

}
