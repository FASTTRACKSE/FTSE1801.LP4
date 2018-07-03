package demo;

public class HinhTron {
	private double banKinh;

	public HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	public double getChuVi() {
		return banKinh * 2 * 3.14;
	}

	public double getDienTich() {
		return banKinh * banKinh * 3.14;
	}

	public void xuat() {
		System.out.println("Chu vi hình tròn: " + getChuVi());
		System.out.println("Diện tích hình tròn: " + getDienTich());
	}
}
