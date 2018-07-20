package quanlysv.moi.model.entity;

public class SinhVien {
	private String tenSinhVien;
	private String maSinhVien;
	private int tuoi;

	public SinhVien() {

	}

	public SinhVien(String maSinhVien,int tuoi, String tenSinhVien) {
		this.maSinhVien = maSinhVien;
		this.tenSinhVien = tenSinhVien;
		this.tuoi = tuoi;
	}

	public String getTenSinhVien() {
		return tenSinhVien;
	}

	public void setTenSinhVien(String tenSinhVien) {
		this.tenSinhVien = tenSinhVien;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	

}
