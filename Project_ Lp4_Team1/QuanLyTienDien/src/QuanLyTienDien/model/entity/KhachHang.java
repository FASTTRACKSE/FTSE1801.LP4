package QuanLyTienDien.model.entity;

public class KhachHang {
	private String maKhachHang;
	private String nameKhachHang;
	private String address;
	private String tenPhuong;
	private String tenQuan;
	private String phone;
	private String email;
	private CongToDien maCongTo;
	private BienLai bienLai;
	private String tienDien;

	public String getTienDien() {
		return tienDien;
	}

	public void setTienDien(String tienDien) {
		this.tienDien = tienDien;
	}

	public BienLai getBienLai() {
		return bienLai;
	}

	public void setBienLai(BienLai bienLai) {
		this.bienLai = bienLai;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getNameKhachHang() {
		return nameKhachHang;
	}

	public void setNameKhachHang(String nameKhachHang) {
		this.nameKhachHang = nameKhachHang;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTenPhuong() {
		return tenPhuong;
	}

	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CongToDien getMaCongTo() {
		return maCongTo;
	}

	public void setMaCongTo(CongToDien maCongTo) {
		this.maCongTo = maCongTo;
	}

}