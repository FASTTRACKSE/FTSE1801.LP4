package baiHoc;

public class ChuNhat extends Hinh {
	double dai;
	double rong;
	
	public ChuNhat(double dai, double rong) {
		this.dai=dai;
		this.rong=rong;
	}
	
	public double chuVi() {
		return (dai+rong)*2;
	}
	
	public double dienTich() {
		return dai*rong;
	}


}
