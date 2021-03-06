package java_tuan2_day11;

public class HinhTron extends Hinh {
	private double banKinh;
	

	public HinhTron(double banKinh) {
		super();
		this.banKinh = banKinh;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	@Override
	public double chuVi() {
		return 3.14*2*banKinh;
	}

	@Override
	public double dienTich() {
		return 3.14*banKinh*banKinh;
	}
	

}
