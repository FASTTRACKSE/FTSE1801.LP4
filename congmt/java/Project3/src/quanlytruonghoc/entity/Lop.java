package quanlytruonghoc.entity;

/**
 * Lop Class
 * 
 * @author CongMT
 *
 */
public class Lop {

	private String idLop;
	private String tenLop;
	private String namHoc;
	private SinhVien sinhvien;

	public Lop() {

	}

	public Lop(String idLop, String tenLop, String namHoc) {

		this.idLop = idLop;
		this.tenLop = tenLop;
		this.namHoc = namHoc;
	}

	public Lop(String idLop, String tenLop, String namHoc, SinhVien sinhvien) {

		this.idLop = idLop;
		this.tenLop = tenLop;
		this.namHoc = namHoc;
		this.sinhvien = sinhvien;
	}

	public SinhVien getSinhVien(){
		return sinhvien;
	}

	public void setSinhVien(SinhVien sinhvien) {
		this.sinhvien = sinhvien;
	}

	public String getIdLop() {
		return idLop;
	}

	public void setIdLop(String idLop) {
		this.idLop = idLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}





}
