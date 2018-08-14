package demotruutuong;

public class HinhChuNhat extends Hinh{
	private double canhDai;
	private double canhRong;
	
	public HinhChuNhat(double canhDai,double canhRong) {
		this.canhDai = canhDai;
		this.canhRong= canhRong;
	};
	
	public double getChuVi(){
		return 2*(canhDai+canhRong);
	}
	public double getDienTich() {
		return canhDai*canhRong;
	}
	void xuat() {
		System.out.println("Chu vi: "+ getChuVi());
		System.out.println("Diện tích: "+ getDienTich());
	}
	public static void main(String[] args) {
		HinhChuNhat hcn = new HinhChuNhat(2, 3);
		hcn.xuat();
	}
}
