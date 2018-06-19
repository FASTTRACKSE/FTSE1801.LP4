package baiHoc;

public class Tron extends Hinh {
	double bankinh;

	
	public Tron(double banKinh) {
	this.bankinh=banKinh;
	}
	public double chuVi() {
		return 3.14*2*bankinh;
	}


	public double dienTich() {
		return 3.14*bankinh*bankinh;
	}

}
