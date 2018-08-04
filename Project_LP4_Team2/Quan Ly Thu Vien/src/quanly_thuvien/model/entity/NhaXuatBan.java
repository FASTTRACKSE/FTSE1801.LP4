package quanly_thuvien.model.entity;

public class NhaXuatBan {
	private int maNhaXuatBan;
	private String NhaXuatBan;

	public NhaXuatBan() {

	}

	public NhaXuatBan(int maNhaXuatBan, String nhaXuatBan) {
		super();
		this.maNhaXuatBan = maNhaXuatBan;
		NhaXuatBan = nhaXuatBan;
	}

	public int getMaNhaXuatBan() {
		return maNhaXuatBan;
	}

	public void setMaNhaXuatBan(int maNhaXuatBan) {
		this.maNhaXuatBan = maNhaXuatBan;
	}

	public String getNhaXuatBan() {
		return NhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		NhaXuatBan = nhaXuatBan;
	}

}
