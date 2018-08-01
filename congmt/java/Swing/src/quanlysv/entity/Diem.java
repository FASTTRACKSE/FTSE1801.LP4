package quanlysv.entity;

public class Diem {
private String monHoc;
private double diem;
public Diem() {}
public Diem(String monHoc, double diem) {
	
	this.monHoc = monHoc;
	this.diem = diem;
}
public String getMonHoc() {
	return monHoc;
}
public void setMonHoc(String monHoc) {
	this.monHoc = monHoc;
}
public double getDiem() {
	return diem;
}
public void setDiem(double diem) {
	this.diem = diem;
}

}
