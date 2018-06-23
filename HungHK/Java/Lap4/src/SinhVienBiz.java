

public class SinhVienBiz extends SinhVienFpt {
	public double diemMarketing;
	public double diemSales;
	
	public SinhVienBiz(String hoTen, String nghanh, double diemMarketing, double diemSales) {
		super(hoTen, nghanh);
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}

	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (diemMarketing*2 + diemSales)/3;
	}
	
}
