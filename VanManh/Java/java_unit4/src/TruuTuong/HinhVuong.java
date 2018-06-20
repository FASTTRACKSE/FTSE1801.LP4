package TruuTuong;

public class HinhVuong extends Hinh {
	private double canh;

	public HinhVuong(double canh) {
		this.canh = canh;
	}

	public double chuVi() {
		return canh * 4;
	}

	public double dienTich() {
		return canh * canh;
	}
}
