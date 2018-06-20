package java_day10_TruuTuong;

public class SinhVienBiz extends SinhVienFpt{
	double diemMaketing;
	double diemSales;
	public SinhVienBiz(String hoTen, String nganh, double diemMaketing, double diemSales) {
		super(hoTen, nganh);
		this.diemMaketing = diemMaketing;
		this.diemSales = diemSales;
	}
	@Override
	double getDiem() {
		// TODO Auto-generated method stub
		return (diemMaketing + diemSales)/2;
	}
	
}
