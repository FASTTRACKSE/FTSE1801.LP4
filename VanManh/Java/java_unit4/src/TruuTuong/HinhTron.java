package TruuTuong;

public class HinhTron extends Hinh {
	private double banKinh;

	public HinhTron(double bk) {
		this.banKinh = bk;
	}

	public double chuVi() {
		return 2 * 3.14 * banKinh;
	}

	public double dienTich() {
		return 3.14 * banKinh * banKinh;
	}

}
