package Bt1;

public class ChuNhat {
	private double dai;
	private double rong;

	public ChuNhat(double dai, double rong) {
		super();
		this.dai = dai;
		this.rong = rong;
	}

	public double getDai() {
		return dai;
	}

	public void setDai(double dai) {
		this.dai = dai;
	}

	public double getRong() {
		return rong;
	}

	public void setRong(double rong) {
		this.rong = rong;
	}

	public double getDienTich() {
		return dai * rong;
	}

	public double getChuVi() {
		return (dai + rong) * 2;
	}

	void xuat() {
		System.out.println("- Đâylà hình chữ nhật :");
		System.out.println("- Chiều dài:" + dai);
		System.out.println("- Chiều rộng:" + rong);
		System.out.println("- Dien tích:" + getDienTich());
		System.out.println("- Chu vi:" + getChuVi());

	}

	
}

