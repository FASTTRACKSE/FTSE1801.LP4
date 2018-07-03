package demo_d6;

public class chuNhat {
	private double rong;
	private double dai;
	
	public chuNhat() {
		System.out.println("chu nhat");
	}
	
	public chuNhat(double rong, double dai) {
		this.rong = rong;
		this.dai = dai;
	}

	public double getRong() {
		return rong;
	}

	public void setRong(double rong) {
		this.rong = rong;
	}

	public double getDai() {
		return dai;
	}

	public void setDai(double dai) {
		this.dai = dai;
	}
	public double getchuVi() {
		return (rong + dai)*2;
	}
	public double getdienTich() {
		return rong*dai;
	}
	public void xuat() {
		System.out.println("Đây là hình vuông");
	}
	public static void main(String[] args) {
		Vuong v = new Vuong(1,1);
	}
}
