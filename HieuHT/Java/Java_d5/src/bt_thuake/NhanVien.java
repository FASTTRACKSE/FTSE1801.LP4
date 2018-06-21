package bt_thuake;

public class NhanVien {
	private String hoTen;
	protected double luong;

	public String gethoTen() {
		return hoTen;
	}

	public void sethoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getluong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public double getthuNhap() {
		return 12 * luong;
	}
}