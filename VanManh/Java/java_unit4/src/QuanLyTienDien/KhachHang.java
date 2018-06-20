package QuanLyTienDien;

public class KhachHang {
	private String name;
	private String address;
	private int maCongTo;
	private int soDienCu;
	private int soDienMoi;
	private double tienDien;

	public int getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(int maCongTo) {
		this.maCongTo = maCongTo;
	}

	public double getTienDien() {
		return tienDien;
	}

	public void setTienDien(double tienDien) {
		this.tienDien = tienDien;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSoDienCu() {
		return soDienCu;
	}

	public void setSoDienCu(int soDienCu) {
		this.soDienCu = soDienCu;
	}

	public int getSoDienMoi() {
		return soDienMoi;
	}

	public void setSoDienMoi(int soDienMoi) {
		this.soDienMoi = soDienMoi;
	}

	public KhachHang() {
	}

	public KhachHang(String name, String address,int maCongTo, int soDienCu, int soDienMoi) {
		this.name = name;
		this.address = address;
		this.maCongTo = maCongTo;
		this.soDienCu = soDienCu;
		this.soDienMoi = soDienMoi;
	}
}
