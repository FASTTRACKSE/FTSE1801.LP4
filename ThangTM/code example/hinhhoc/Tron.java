package demo.hinhhoc;

public class Tron extends Hinh {
	private double banKinh;

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	public double chuVi() {
		return 3.14 * 2 * banKinh;
	}

	public double dienTich() {
		return 3.14 * banKinh * banKinh;
	}

}
