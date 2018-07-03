package demo;

public class NhanVien {
	private String hoTen;
	protected double luong;

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public double getThuNhap() {
		return 12 * luong;
	}

}
