package demo.hinhhoc;

public class ChuNhat extends Hinh {
	private double dai;
	private double rong;

	public ChuNhat() {
		System.out.println("Chu Nhat");
	}
	public ChuNhat(double dai, double rong) {
		this.dai = dai;
		this.rong = rong;
	}

	public void xuat() {
		System.out.format("Hinh chu nhat co chieu dai la %d va chieu rong la %d", dai, rong);
	}

	public double chuVi() {
		return (dai + rong) * 2;
	}

	public double dienTich() {
		return dai * rong;
	}
}
