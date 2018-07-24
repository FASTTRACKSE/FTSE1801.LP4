package quanlytruonghoc.entity;

/**
 * SinhVien Class
 * 
 * @author CongMT
 *
 */
public class SinhVien {

	private String idSinhVien;
	private String hoTen;
	private String idLop;
	private String quan;
	private String thanhpho;
	private String diaChi;
	private String email;
	private String sdt;
	private Diem diem;
	private MonHoc monHoc;
	private Lop lop;
	private Phuong phuong;

	public SinhVien() {
	}

	public SinhVien(String idSinhVien, String hoTen, Diem diem, MonHoc monHoc, Lop lop) {
		super();
		this.idSinhVien = idSinhVien;
		this.hoTen = hoTen;
		this.diem = diem;
		this.monHoc = monHoc;
		this.lop = lop;
	}

	public SinhVien(String idSinhVien, String hoTen, String quan, String thanhpho, String diaChi, String email,
			String sdt, Phuong phuong) {
		super();
		this.idSinhVien = idSinhVien;
		this.hoTen = hoTen;
		this.quan = quan;
		this.thanhpho = thanhpho;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
		this.phuong = phuong;
	}


	public Phuong getPhuong() {
		return phuong;
	}

	public void setPhuong(Phuong phuong) {
		this.phuong = phuong;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public Diem getDiem() {
		return diem;
	}

	public void setDiem(Diem diem) {
		this.diem = diem;
	}

	public String getIdSinhVien() {
		return idSinhVien;
	}

	public void setIdSinhVien(String idSinhVien) {
		this.idSinhVien = idSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getIdLop() {
		return idLop;
	}

	public void setIdLop(String idLop) {
		this.idLop = idLop;
	}

	

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getThanhpho() {
		return thanhpho;
	}

	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

}
