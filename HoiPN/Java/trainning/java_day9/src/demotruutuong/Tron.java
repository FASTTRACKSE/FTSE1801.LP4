package demotruutuong;

public class Tron extends Hinh{
	double banKinh;
	
	public Tron(double banKinh) {
		this.banKinh = banKinh;
	}
	
	public double getChuVi() {
		return 2*3.14*banKinh;
		
	}

	@Override
	public double getDienTich() {
		return 3.14*banKinh*banKinh;
	}
	
	void xuat() {
		System.out.println("Chu vi: "+ getChuVi());
		System.out.println("Diện tích: "+ getDienTich());
	}
	
}
