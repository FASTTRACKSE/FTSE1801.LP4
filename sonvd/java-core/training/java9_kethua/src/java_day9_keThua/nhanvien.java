package java_day9_keThua;

public class nhanvien {
	private String hoTen;
	private int luong;
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	public int getThuNhap() {
		return luong*12;
	}
}