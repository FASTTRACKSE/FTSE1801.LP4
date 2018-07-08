
public class User {
	private String hoTen;
	private double soTien;
	private String loaiTien;
	private String trangThai;
	public User(String hoTen, double soTien, String loaiTien, String trangThai) {
		this.hoTen = hoTen;
		this.soTien = soTien;
		this.loaiTien = loaiTien;
		this.trangThai = trangThai;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public double getSoTien() {
		return soTien;
	}
	public void setSoTien(double soTien) {
		this.soTien = soTien;
	}
	public String getLoaiTien() {
		return loaiTien;
	}
	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	
}
