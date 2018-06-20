package java_tuan3;

public class KhachHang {
private String hoTen;
private int soNha;
private int maSoCongTo;
private int chiSoCu;
private int chiSoMoi;
public double soTienPhaiTra;



public KhachHang(String hoTen, int soNha, int maSoCongTo, int chiSoCu, int chiSoMoi, double soTienPhaiTra) {
	super();
	this.hoTen = hoTen;
	this.soNha = soNha;
	this.maSoCongTo = maSoCongTo;
	this.chiSoCu = chiSoCu;
	this.chiSoMoi = chiSoMoi;
	this.soTienPhaiTra = soTienPhaiTra;
}

public KhachHang() {
	
}

public String getHoTen() {
	return hoTen;
}


public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public int getSoNha() {
	return soNha;
}
public void setSoNha(int soNha) {
	this.soNha = soNha;
}
public int getMaSoCongTo() {
	return maSoCongTo;
}
public void setMaSoCongTo(int maSoCongTo) {
	this.maSoCongTo = maSoCongTo;
}
public int getChiSoCu() {
	return chiSoCu;
}

public void setChiSoCu(int chiSoCu) {
	this.chiSoCu = chiSoCu;
}

public int getChiSoMoi() {
	return chiSoMoi;
}

public void setChiSoMoi(int chiSoMoi) {
	this.chiSoMoi = chiSoMoi;
}

public double getSoTienPhaiTra() {
	return soTienPhaiTra;
}

public void setSoTienPhaiTra( double soTienPhaiTra) {
	this.soTienPhaiTra = soTienPhaiTra;
}

}
