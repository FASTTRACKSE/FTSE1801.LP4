package java_day9_keThua;

public class ChuNhat {
	private double dai;
	private double rong;
	public ChuNhat(double dai,double rong) {
		this.dai = dai;
		this.rong= rong;
	};
	
	double getChuVi(){
		return 2*(dai+rong);
	}
	double getDienTich() {
		return dai*rong;
	}
	void xuat() {
		System.out.println("Hình có chiều dài: " + dai);
		System.out.println("Hình có chiều rộng: " +rong);
		System.out.println("Chu vi: "+ getChuVi());
		System.out.println("Diện tích: "+ getDienTich());
	}
}
