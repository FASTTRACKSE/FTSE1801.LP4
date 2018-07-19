package entity;

public class SinhVien {
	private String maSinhVien;
	private String tenSinhVien;
	private String password;
	Diem diem;
	
	public SinhVien() {
		
	}

	public SinhVien(String maSinhVien, String tenSinhVien, String password, Diem diem) {
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.password = password;
		this.diem = diem;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Diem getDiem() {
		return diem;
	}

	public void setDiem(Diem diem) {
		this.diem = diem;
	}
	
	
}
