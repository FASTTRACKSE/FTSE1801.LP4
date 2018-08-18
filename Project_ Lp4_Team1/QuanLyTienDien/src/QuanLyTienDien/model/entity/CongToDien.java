package quanlytiendien.model.entity;

public class CongToDien {
	private String maCongTo;
	private String loaiCongTo;
	private String nhaSanXuat;
	private String namSanXuat;

	public CongToDien() {
	}

	public CongToDien(String maCongTo, String loaiCongTo, String nhaSanXuat, String namSanXuat) {
		this.maCongTo = maCongTo;
		this.loaiCongTo = loaiCongTo;
		this.nhaSanXuat = nhaSanXuat;
		this.namSanXuat = namSanXuat;
	}

	public String getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(String maCongTo) {
		this.maCongTo = maCongTo;
	}

	public String getLoaiCongTo() {
		return loaiCongTo;
	}

	public void setLoaiCongTo(String loaiCongTo) {
		this.loaiCongTo = loaiCongTo;
	}

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public String getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(String namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String toString() {
		return maCongTo;
	}
}
