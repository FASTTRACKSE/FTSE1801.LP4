package java_day10_TruuTuong;

public class CHuNhat extends Hinh {
	private double dai;
	private double rong;
	public CHuNhat(double dai,double rong) {
		this.dai = dai;
		this.rong= rong;
	};
	
	void xuat() {
		System.out.println("Hình có chiều dài: " + dai);
		System.out.println("Hình có chiều rộng: " +rong);
		System.out.println("Chu vi: "+ chuVi());
		System.out.println("Diện tích: "+ dienTich());
	}

	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return (dai + rong) *2;
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return dai*rong;
	}
}
