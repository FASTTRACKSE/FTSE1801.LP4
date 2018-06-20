package assignment3;

public class Vuong extends ChuNhat {
	public Vuong(double canh) {
		super(canh, canh);
	}

	public void xuat() {
		System.out.println("Đây là hình vuông");
		super.xuat();
	}
}
