package java_tuan2_day1;

public class LaoCong extends nhanvien {
	private int soGioLamThem;

	public int getSoGioLamThem() {
		return soGioLamThem;
	}

	public void setSoGioLamThem(int soGioLamThem) {
		this.soGioLamThem = soGioLamThem;
	}
	public double getThuNhap() {
		return super.getThuNhap() + soGioLamThem;
	}
}
