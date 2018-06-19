package baiHoc;

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

	void xuat(String hoTen, double luong) {
		System.out.println(hoTen + ", " + luong);

	}

	public double thueThuNhap() {
		return luong * 12;
	}

}
