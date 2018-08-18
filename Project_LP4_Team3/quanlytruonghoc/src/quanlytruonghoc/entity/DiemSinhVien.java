package quanlytruonghoc.entity;

public class DiemSinhVien {
	private String idSinhVien;
	private double diemJava;
	private double diemHTML;
	private double diemCSS;
	private double diemEnglish;
	
	
	public DiemSinhVien() {
		super();
	}

	public DiemSinhVien(String idMonHoc, String idSinhVien, double diemJava, double diemHTML, double diemCSS,
			double diemEnglish) {
		super();
		
		this.idSinhVien = idSinhVien;
		this.diemJava = diemJava;
		this.diemHTML = diemHTML;
		this.diemCSS = diemCSS;
		this.diemEnglish = diemEnglish;
	}

	public String getIdSinhVien() {
		return idSinhVien;
	}
	public void setIdSinhVien(String idSinhVien) {
		this.idSinhVien = idSinhVien;
	}
	public double getDiemJava() {
		return diemJava;
	}
	public void setDiemJava(double diemJava) {
		this.diemJava = diemJava;
	}
	public double getDiemHTML() {
		return diemHTML;
	}
	public void setDiemHTML(double diemHTML) {
		this.diemHTML = diemHTML;
	}
	public double getDiemCSS() {
		return diemCSS;
	}
	public void setDiemCSS(double diemCSS) {
		this.diemCSS = diemCSS;
	}
	public double getDiemEnglish() {
		return diemEnglish;
	}
	public void setDiemEnglish(double diemEnglish) {
		this.diemEnglish = diemEnglish;
	}
	
	
}
