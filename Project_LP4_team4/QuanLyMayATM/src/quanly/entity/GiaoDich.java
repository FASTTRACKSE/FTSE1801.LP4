package quanly.entity;

public class GiaoDich {
	private int maGiaoDich;
	private String thoiGian;
	private String soTien;
	private KhachHang khachHang;
	private MayATM mayATM;

	public int getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(int maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getSoTien() {
		return soTien;
	}

	public void setSoTien(String soTien) {
		this.soTien = soTien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public MayATM getMayATM() {
		return mayATM;
	}

	public void setMayATM(MayATM mayATM) {
		this.mayATM = mayATM;
	}

}