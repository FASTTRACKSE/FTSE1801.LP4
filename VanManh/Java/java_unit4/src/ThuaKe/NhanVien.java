package ThuaKe;

public class NhanVien {
	private String hoTen;
	private double luong;

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
		return luong * 12;

	}
}
