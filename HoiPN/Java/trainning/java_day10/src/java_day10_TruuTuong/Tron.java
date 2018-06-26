package java_day10_TruuTuong;

public class Tron extends Hinh{
	private double banKinh;
	

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	@Override
	public double chuVi() {
		// TODO Auto-generated method stub
		return 3.14 * 2*banKinh;
	}

	@Override
	public double dienTich() {
		// TODO Auto-generated method stub
		return 3.14*banKinh*banKinh;
	}
}
