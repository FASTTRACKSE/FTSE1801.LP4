package quanlysv.moi.entity;


public class SinhVien {
	private String maSV;
	private String tenSv;
	private String pass;
	private Diem diem;

	public SinhVien() {
	}

	public SinhVien(String maSV, String tenSv, String pass, Diem diem) {
		this.maSV = maSV;
		this.tenSv = tenSv;
		this.pass = pass;
		this.diem = diem;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSv() {
		return tenSv;
	}

	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Diem getDiem() {
		return diem;
	}

	public void setDiem(Diem diem) {
		this.diem = diem;
	}

	

}
