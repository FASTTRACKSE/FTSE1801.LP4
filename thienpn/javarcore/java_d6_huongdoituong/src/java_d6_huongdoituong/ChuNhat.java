package java_d6_huongdoituong;

public class ChuNhat extends Hinh {
       private double Dai;
       private double Rong;
	public double getDai() {
		return Dai;
	}
	public void setDai(double dai) {
		Dai = dai;
	}
	public double getRong() {
		return Rong;
	}
	public void setRong(double rong) {
		Rong = rong;
	}
	
	public ChuNhat(double dai, double rong) {
		
		Dai = dai;
		Rong = rong;
	}
	double ChuVi() {
		
		return (Dai + Rong)*2;
	}
	
	double DienTich() {
		
		return Dai*Rong;
	}
	public void xuat() {
		
		System.out.println("Dai: "+Dai);
		System.out.println("Rộng: "+Rong);
		System.out.println("Chu vi: "+ChuVi());
		System.out.println("Diện tích: "+DienTich());
	}
	
	
	
}
