package QuanLyTienDien.model.entity;

public class CongToDien {
	private String maCongTo;

	public CongToDien() {
	}

	public CongToDien(String maCongTo) {
		this.maCongTo = maCongTo;
	}

	public String getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}

	public String toString() {
		return maCongTo;
	}
}
