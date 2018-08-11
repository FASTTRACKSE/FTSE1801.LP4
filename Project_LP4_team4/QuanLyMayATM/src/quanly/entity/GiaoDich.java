package quanly.entity;

public class GiaoDich {
	private int maGiaoDich;
	private String thoiGian;
	private String soTienRut;
	private String soTienThem;
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

	public String getSoTienRut() {
		return soTienRut;
	}

	public void setSoTienRut(String soTienRut) {
		this.soTienRut = soTienRut;
	}

	public String getSoTienThem() {
		return soTienThem;
	}

	public void setSoTienThem(String soTienThem) {
		this.soTienThem = soTienThem;
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
