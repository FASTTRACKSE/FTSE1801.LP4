package baiHoc;

public class Vuong extends Hinh {
	double canh;
	
	public Vuong(double canh) {
	this.canh=canh;
	}
	
	public double chuVi() {
		return canh*4;
	}

	
	public double dienTich() {
		return canh*canh;
	}

}
