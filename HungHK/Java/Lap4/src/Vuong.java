

public class Vuong extends ChuNhat {
	public Vuong(double canh) {
		super(canh, canh);
	}
	public void xuat() {
		System.out.println("Chu vi hình vuông là: " + getChuVi());
		System.out.println("Diện tích hình vuông là: " + getDienTich());
		System.out.println();
	}
}
