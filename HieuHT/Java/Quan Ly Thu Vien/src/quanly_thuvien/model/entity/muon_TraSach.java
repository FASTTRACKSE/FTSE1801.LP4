package quanly_thuvien.model.entity;

public class muon_TraSach {
	private String MaGiaoDich;
	private String NgayMuon;
	private String NgayTra;
	private QuanLy_BanDoc MaThanhVien;
	private QuanLySach MaSach;
	private String tinhTrang;

	public muon_TraSach() {

	}

	public muon_TraSach(String maGiaoDich, String ngayMuon, String ngayTra, QuanLy_BanDoc maThanhVien,
			QuanLySach maSach, String tinhTrang) {
		super();
		MaGiaoDich = maGiaoDich;
		NgayMuon = ngayMuon;
		NgayTra = ngayTra;
		MaThanhVien = maThanhVien;
		MaSach = maSach;
		this.tinhTrang = tinhTrang;
	}

	public String getMaGiaoDich() {
		return MaGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		MaGiaoDich = maGiaoDich;
	}

	public String getNgayMuon() {
		return NgayMuon;
	}

	public void setNgayMuon(String ngayMuon) {
		NgayMuon = ngayMuon;
	}

	public String getNgayTra() {
		return NgayTra;
	}

	public void setNgayTra(String ngayTra) {
		NgayTra = ngayTra;
	}

	public QuanLy_BanDoc getMaThanhVien() {
		return MaThanhVien;
	}

	public void setMaThanhVien(QuanLy_BanDoc maThanhVien) {
		MaThanhVien = maThanhVien;
	}

	public QuanLySach getMaSach() {
		return MaSach;
	}

	public void setMaSach(QuanLySach maSach) {
		MaSach = maSach;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}
