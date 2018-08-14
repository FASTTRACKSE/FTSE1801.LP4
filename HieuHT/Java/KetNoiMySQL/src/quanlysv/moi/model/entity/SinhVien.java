package quanlysv.moi.model.entity;

public class SinhVien {
	private String maSinhVien;
	private String tenSinhVien;
	private String password;
	private int tuoi;
	private Diem diem;
	
	

	public SinhVien() {
	}
	

	


	public SinhVien(String maSinhVien, String tenSinhVien, String password, int tuoi, Diem diem) {
		super();
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.password = password;
		this.tuoi = tuoi;
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

	public int getTuoi() {
		return tuoi;
	}


	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
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