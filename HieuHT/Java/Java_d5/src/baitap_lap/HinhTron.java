package baitap_lap;

public class HinhTron {
	double banKinh;

	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	public double getchuVi() {
		return banKinh * 2 * 3.14;
	}

	public double getdienTich() {
		return Math.pow(banKinh, 2) * 3.14;
	}
	public void xuat() {
		System.out.println("Hình Tròn:");
		System.out.println("Chu Vi: " + getchuVi());
		System.out.println("Diện Tích: "+getdienTich());
	}
}
