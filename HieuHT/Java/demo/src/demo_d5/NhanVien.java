package demo_d5;

public class NhanVien {
	private String ten;
	private int tuoi;
	private String diaChi;
	private String gioiTinh;
	private double luong;
	public NhanVien() {
		ten = "Hiệu";
		tuoi = 21;
		diaChi = "Quãng Nam";
	}
	public NhanVien(String ten, int tuoi, String diaChi) {
		this.ten = ten;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
	}
	public NhanVien(String ten, int tuoi, String diaChi, String gioiTinh, double luong) {
		this(ten, tuoi, diaChi);
		this.gioiTinh = gioiTinh;
		this.luong = luong;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	public static void main(String[] args) {
		NhanVien nv1 = new NhanVien("Hiệu", 21, "Quãng Nam", "Nam", 213123);
		NhanVien nv2 = new NhanVien();
	}
}
