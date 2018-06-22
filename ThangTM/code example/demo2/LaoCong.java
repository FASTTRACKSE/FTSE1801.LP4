package demo.demo2;

public class LaoCong extends NhanVien {
	private double tienLamThem;

	public double getTienLamThem() {
		return tienLamThem;
	}

	public void setTienLamThem(double tienLamThem) {
		this.tienLamThem = tienLamThem;
	}

	public double getThuNhap() {
		return super.getThuNhap() + tienLamThem;
	}

}
