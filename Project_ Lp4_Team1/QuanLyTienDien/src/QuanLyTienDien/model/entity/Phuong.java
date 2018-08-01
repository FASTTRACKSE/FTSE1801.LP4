package QuanLyTienDien.model.entity;

public class Phuong {
	private int maPhuong;
	private String namePhuong;
	private Quan maQuan;

	public int getMaPhuong() {
		return maPhuong;
	}

	public void setMaPhuong(int maPhuong) {
		this.maPhuong = maPhuong;
	}

	public String getNamePhuong() {
		return namePhuong;
	}

	public void setNamePhuong(String namePhuong) {
		this.namePhuong = namePhuong;
	}

	public Quan getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(Quan maQuan) {
		this.maQuan = maQuan;
	}

	public Phuong(int maPhuong, String namePhuong, Quan maQuan) {
		this.maPhuong = maPhuong;
		this.namePhuong = namePhuong;
		this.maQuan = maQuan;
	}

	public Phuong() {
	}

	public String toString() {
		return namePhuong;
	}
}
