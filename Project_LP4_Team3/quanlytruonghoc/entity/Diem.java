package quanlytruonghoc.entity;

/**
 * Diem Class
 * @author COngMT
 *
 */
public class Diem {

	private String idMonHoc;
	private String idSinhVien;
	private double diemThi;

	public Diem(String idMonHoc, String idSinhVien, double diemThi) {
		super();
		this.idMonHoc = idMonHoc;
		this.idSinhVien = idSinhVien;
		this.diemThi = diemThi;
	}


	public Diem() {
		super();
	}
	
	
	public String getIdMonHoc() {
		return idMonHoc;
	}
	public void setIdMonHoc(String idMonHoc) {
		this.idMonHoc = idMonHoc;
	}
	public String getIdSinhVien() {
		return idSinhVien;
	}
	public void setIdSinhVien(String idSinhVien) {
		this.idSinhVien = idSinhVien;
	}
	public double getDiemThi() {
		return diemThi;
	}
	public void setDiemThi(double diemThi) {
		this.diemThi = diemThi;
	}
	
	

	/*public Diem() {
	}

	public Diem( String monHoc,double diemThi, String xepLoai) {
		this.monHoc = monHoc;
		this.diemThi = diemThi;
		this.xepLoai = xepLoai;
	}
	

	public Diem(String idLop, String monHoc, String idMonHoc, String idSinhVien, double diemThi, String xepLoai) {
		super();
		this.idLop = idLop;
		this.monHoc = monHoc;
		this.idMonHoc = idMonHoc;
		this.idSinhVien = idSinhVien;
		this.diemThi = diemThi;
		this.xepLoai = xepLoai;
	}

	public String getIdLop() {
		return idLop;
	}

	public void setIdLop(String idLop) {
		this.idLop = idLop;
	}

	public String getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	public String getIdMonHoc() {
		return idMonHoc;
	}

	public void setIdMonHoc(String idMonHoc) {
		this.idMonHoc = idMonHoc;
	}

	public String getIdSinhVien() {
		return idSinhVien;
	}

	public void setIdSinhVien(String idSinhVien) {
		this.idSinhVien = idSinhVien;
	}

	public double getDiemThi() {
		return diemThi;
	}

	public void setDiemThi(double diemThi) {
		this.diemThi = diemThi;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}*/

}
