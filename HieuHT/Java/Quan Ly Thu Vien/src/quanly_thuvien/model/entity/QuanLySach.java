package quanly_thuvien.model.entity;

public class QuanLySach {
	private String MaSach;
	private String TenSach;
	private String TacGia;
	private String NhaXuatBan;
	private String TheLoaiSach;
	private String NamXuatBan;
	private String soLuong;

	public QuanLySach(String maSach, String tenSach, String tacGia, String nhaXuatBan, String theLoaiSach,
			String namXuatBan, String soLuong) {
		super();
		MaSach = maSach;
		TenSach = tenSach;
		TacGia = tacGia;
		NhaXuatBan = nhaXuatBan;
		TheLoaiSach = theLoaiSach;
		NamXuatBan = namXuatBan;
		this.soLuong = soLuong;
	}

	public QuanLySach() {

	}

	public String getMaSach() {
		return MaSach;
	}

	public void setMaSach(String maSach) {
		MaSach = maSach;
	}

	public String getTenSach() {
		return TenSach;
	}

	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}

	public String getTacGia() {
		return TacGia;
	}

	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return NhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		NhaXuatBan = nhaXuatBan;
	}

	public String getTheLoaiSach() {
		return TheLoaiSach;
	}

	public void setTheLoaiSach(String theLoaiSach) {
		TheLoaiSach = theLoaiSach;
	}

	public String getNamXuatBan() {
		return NamXuatBan;
	}

	public void setNamXuatBan(String namXuatBan) {
		NamXuatBan = namXuatBan;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}

	public void setMaNhaXuatBan(String string) {
		// TODO Auto-generated method stub

	}

	public void setMaTheLoaiSach(String string) {
		// TODO Auto-generated method stub

	}

}
