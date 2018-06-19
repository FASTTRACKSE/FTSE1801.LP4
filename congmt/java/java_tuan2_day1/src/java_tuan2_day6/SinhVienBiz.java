package java_tuan2_day6;

public class SinhVienBiz extends SinhVienFPT{
private double diemMaketting;
private double diemSales;
@Override
public double getDiemTB() {
	// TODO Auto-generated method stub
	return (2*diemMaketting + diemSales)/3;
}
public SinhVienBiz(String hoTen, String nganh, double diemMaketting, double diemSales) {
	super(hoTen, nganh);
	this.diemMaketting = diemMaketting;
	this.diemSales = diemSales;
}
public double getDiemMaketting() {
	return diemMaketting;
}
public void setDiemMaketting(double diemMaketting) {
	this.diemMaketting = diemMaketting;
}
public double getDiemSales() {
	return diemSales;
}
public void setDiemSales(double diemSales) {
	this.diemSales = diemSales;
}

}
