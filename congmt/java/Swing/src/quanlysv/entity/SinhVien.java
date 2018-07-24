package quanlysv.entity;

public class SinhVien {
private String maSinhVien;
private String tenSinhVien;
private String passSinhVien;
private Diem diem;
public SinhVien() {}
public SinhVien(String maSinhVien, String tenSinhVien, String passSinhVien, Diem diem) {
	super();
	this.maSinhVien = maSinhVien;
	this.tenSinhVien = tenSinhVien;
	this.passSinhVien = passSinhVien;
	this.diem = diem;
}
public String getMaSinhVien() {
	return maSinhVien;
}
public void setMaSinhVien(String maSinhVien) {
	this.maSinhVien = maSinhVien;
}
public String getTenSinhVien() {
	return tenSinhVien;
}
public void setTenSinhVien(String tenSinhVien) {
	this.tenSinhVien = tenSinhVien;
}
public String getPassSinhVien() {
	return passSinhVien;
}
public void setPassSinhVien(String passSinhVien) {
	this.passSinhVien = passSinhVien;
}
public Diem getDiem() {
	return diem;
}
public void setDiem(Diem diem) {
	this.diem = diem;
}



}
