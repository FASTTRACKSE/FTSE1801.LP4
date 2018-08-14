package quanlysv.moi.model.entity;

public class Diem {
	private String monhoc;
	private int diem;

	public Diem() {
	}
	
	public Diem(String monhoc, int diem) {
		this.monhoc = monhoc;
		this.diem = diem;
	}

	public String getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(String monhoc) {
		this.monhoc = monhoc;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

}