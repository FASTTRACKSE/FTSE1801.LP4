package demo_d4;

public class laoCong extends NhanVien {
	private double tienLamThem;

	public double getTienLamThem() {
		return tienLamThem;
	}

	public void setTienLamThem(double tienLamThem) {
		this.tienLamThem = tienLamThem;
	}

	public double getThuNhap() {
		return super.getthuNhap() + tienLamThem;
	}
}